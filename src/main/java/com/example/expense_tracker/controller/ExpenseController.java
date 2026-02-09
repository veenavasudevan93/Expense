package com.example.expense_tracker.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense_tracker.entity.Expense;
import com.example.expense_tracker.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
@Autowired
private ExpenseService service;

//Get all
@GetMapping
public List<Expense> getExpenses(
        @RequestParam(required = false) Integer month
) {
    if (month == null) {
        return service.getAllExpenses();
    }
    return service.getExpensesByMonth(month);
}

/*@GetMapping
public List<Expense> getAllExpenses()
{
	return service.getAllExpenses();
}*/

//GET BY ID
@GetMapping("/{id}")
public Expense getExpenseById(@PathVariable Long id)
{
	return service.getExpenseById(id);
}

//POST
@PostMapping
public Expense addExpense(@RequestBody Expense expense)
{
	return service.saveExpense(expense);
}

@PutMapping("/{id}")
public Expense updateExpense(@PathVariable Long id,@RequestBody Expense expense)
{
	return service.saveExpense(expense);
}

//DELETE
@DeleteMapping("/{id}")

public String deleteExpense(@PathVariable Long id)
{
	service.deleteExpense(id);
	return "Expense deleted successfully";
}

}