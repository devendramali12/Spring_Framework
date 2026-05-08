package com.expense.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "expenses")
@Data // Lombok: generates getters, setters, toString
@NoArgsConstructor // Lombok: no-arg constructor
@AllArgsConstructor // Lombok: all-arg constructor
@Builder // Lombok: builder pattern
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Title is required")
	@Column(nullable = false)
	private String title;

	@NotNull(message = "Amount is required")
	@Positive(message = "Amount must be positive")
	@Column(nullable = false)
	private Double amount;

	@NotBlank(message = "Category is required")
	@Column(nullable = false)
	private String category;

	@NotNull(message = "Date is required")
	@Column(nullable = false)
	private LocalDate date;

	@Column(length = 500)
	private String description;
}