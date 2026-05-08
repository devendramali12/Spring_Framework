package com.expense.service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.expense.dto.ExpenseDTO;
import com.expense.model.Expense;
import com.expense.repository.ExpenseRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Lombok: constructor injection
public class ExpenseService {

	private final ExpenseRepository expenseRepository;

	// ── CREATE ──────────────────────────────────────────
	public ExpenseDTO createExpense(ExpenseDTO dto) {
		Expense expense = mapToEntity(dto);
		Expense saved = expenseRepository.save(expense);
		return mapToDTO(saved);
	}

	// ── GET ALL ─────────────────────────────────────────
	public List<ExpenseDTO> getAllExpenses() {
		return expenseRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// ── GET BY ID ───────────────────────────────────────
	public ExpenseDTO getExpenseById(Long id) {
		Expense expense = expenseRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Expense not found with id: " + id));
		return mapToDTO(expense);
	}

	// ── UPDATE ──────────────────────────────────────────
	public ExpenseDTO updateExpense(Long id, ExpenseDTO dto) {
		Expense existing = expenseRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Expense not found with id: " + id));

		existing.setTitle(dto.getTitle());
		existing.setAmount(dto.getAmount());
		existing.setCategory(dto.getCategory());
		existing.setDate(dto.getDate());
		existing.setDescription(dto.getDescription());

		return mapToDTO(expenseRepository.save(existing));
	}

	// ── DELETE ──────────────────────────────────────────
	public void deleteExpense(Long id) {
		if (!expenseRepository.existsById(id)) {
			throw new EntityNotFoundException("Expense not found with id: " + id);
		}
		expenseRepository.deleteById(id);
	}

	// ── FILTER ──────────────────────────────────────────
	public List<ExpenseDTO> filterExpenses(String category, LocalDate start, LocalDate end) {
		List<Expense> results;

		if (category != null && start != null && end != null) {
			results = expenseRepository.findByCategoryAndDateBetween(category, start, end);
		} else if (category != null) {
			results = expenseRepository.findByCategory(category);
		} else if (start != null && end != null) {
			results = expenseRepository.findByDateBetween(start, end);
		} else {
			results = expenseRepository.findAll();
		}

		return results.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// ── SUMMARY: Total by Category ───────────────────────
	public Map<String, Double> getCategoryTotals() {
		List<Object[]> raw = expenseRepository.getTotalByCategory();
		Map<String, Double> result = new LinkedHashMap<>();
		for (Object[] row : raw) {
			result.put((String) row[0], (Double) row[1]);
		}
		return result;
	}

	// ── SUMMARY: Monthly Totals ──────────────────────────
	public Map<String, Double> getMonthlyTotals(int year) {
		List<Object[]> raw = expenseRepository.getMonthlyTotals(year);
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		Map<String, Double> result = new LinkedHashMap<>();
		for (Object[] row : raw) {
			int monthIndex = ((Number) row[0]).intValue() - 1;
			result.put(months[monthIndex], (Double) row[1]);
		}
		return result;
	}

	// ── GRAND TOTAL ──────────────────────────────────────
	public Double getGrandTotal() {
		return expenseRepository.findAll().stream().mapToDouble(Expense::getAmount).sum();
	}

	// ── MAPPER METHODS ───────────────────────────────────
	private Expense mapToEntity(ExpenseDTO dto) {
		return Expense.builder().id(dto.getId()).title(dto.getTitle()).amount(dto.getAmount())
				.category(dto.getCategory()).date(dto.getDate()).description(dto.getDescription()).build();
	}

	private ExpenseDTO mapToDTO(Expense expense) {
		return ExpenseDTO.builder().id(expense.getId()).title(expense.getTitle()).amount(expense.getAmount())
				.category(expense.getCategory()).date(expense.getDate()).description(expense.getDescription()).build();
	}
}