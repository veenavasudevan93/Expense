package com.example.expense_tracker.service;
import com.example.expense_tracker.entity.Expense;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.expense_tracker.repository.ExpenseRepository;

@Service
public class ExpenseService {
@Autowired
 private ExpenseRepository repository;

public List<Expense>getAllExpenses() {
return repository.findAll()	;
}
public Expense getExpenseById(Long id)
{
	return repository.findById(id).orElse(null);
	}
public Expense saveExpense(Expense expense) 
	{
		return repository.save(expense);
	}
public void deleteExpense(Long id)
{
	repository.deleteById(id);
}
public List<Expense> getExpensesByMonth(int month) {
    LocalDate start = LocalDate.of(LocalDate.now().getYear(), month, 1);
    LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
    return repository.findByDateBetween(start, end);
}

}
