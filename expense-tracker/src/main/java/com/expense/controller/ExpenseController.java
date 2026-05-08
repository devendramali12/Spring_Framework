package com.expense.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expense.dto.ExpenseDTO;
import com.expense.service.ExpenseService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*") // allows frontend JS to call the API
@RequiredArgsConstructor
public class ExpenseController {

	private final ExpenseService expenseService;

	// POST /api/expenses → Create
	@PostMapping
	public ResponseEntity<ExpenseDTO> create(@Valid @RequestBody ExpenseDTO dto) {
		return new ResponseEntity<>(expenseService.createExpense(dto), HttpStatus.CREATED);
	}

	// GET /api/expenses → Get All
	@GetMapping
	public ResponseEntity<List<ExpenseDTO>> getAll() {
		return ResponseEntity.ok(expenseService.getAllExpenses());
	}

	// GET /api/expenses/{id} → Get by ID
	@GetMapping("/{id}")
	public ResponseEntity<ExpenseDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(expenseService.getExpenseById(id));
	}

	// PUT /api/expenses/{id} → Update
	@PutMapping("/{id}")
	public ResponseEntity<ExpenseDTO> update(@PathVariable Long id, @Valid @RequestBody ExpenseDTO dto) {
		return ResponseEntity.ok(expenseService.updateExpense(id, dto));
	}

	// DELETE /api/expenses/{id} → Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		expenseService.deleteExpense(id);
		return ResponseEntity.noContent().build();
	}

	// GET /api/expenses/filter?category=Food&start=2024-01-01&end=2024-12-31
	@GetMapping("/filter")
	public ResponseEntity<List<ExpenseDTO>> filter(@RequestParam(required = false) String category,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
		return ResponseEntity.ok(expenseService.filterExpenses(category, start, end));
	}

	// GET /api/expenses/summary/category → For Pie Chart
	@GetMapping("/summary/category")
	public ResponseEntity<Map<String, Double>> categoryTotals() {
		return ResponseEntity.ok(expenseService.getCategoryTotals());
	}

	// GET /api/expenses/summary/monthly?year=2024 → For Bar Chart
	@GetMapping("/summary/monthly")
	public ResponseEntity<Map<String, Double>> monthlyTotals(@RequestParam(defaultValue = "2024") int year) {
		return ResponseEntity.ok(expenseService.getMonthlyTotals(year));
	}

	// GET /api/expenses/summary/total → Grand Total
	@GetMapping("/summary/total")
	public ResponseEntity<Double> grandTotal() {
		return ResponseEntity.ok(expenseService.getGrandTotal());
	}
}