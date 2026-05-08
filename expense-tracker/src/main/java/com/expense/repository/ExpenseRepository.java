package com.expense.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.expense.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	// Filter by category
	List<Expense> findByCategory(String category);

	// Filter by date range
	List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);

	// Filter by category AND date range
	List<Expense> findByCategoryAndDateBetween(String category, LocalDate startDate, LocalDate endDate);

	// Total amount by category (for pie chart)
	@Query("SELECT e.category, SUM(e.amount) FROM Expense e GROUP BY e.category")
	List<Object[]> getTotalByCategory();

	// Monthly totals (for bar chart)
	@Query("SELECT MONTH(e.date), SUM(e.amount) FROM Expense e " + "WHERE YEAR(e.date) = :year GROUP BY MONTH(e.date)")
	List<Object[]> getMonthlyTotals(@Param("year") int year);
}