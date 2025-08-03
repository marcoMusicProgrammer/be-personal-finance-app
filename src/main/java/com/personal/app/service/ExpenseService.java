package com.personal.app.service;

import java.util.List;

import com.personal.app.models.entities.Expense;
import com.personal.app.models.repositories.BaseRepository;

public class ExpenseService {
    private final BaseRepository<Expense> repo;
    
    public ExpenseService(BaseRepository<Expense> repository) {
        this.repo = repository;
    }
    
    public void addExpense(Expense expense) {
        if ( expense.getAmount() < 0) throw new IllegalArgumentException("Amount cannot be negative");
        repo.insert(expense);
    }

    public List<Expense> getExpenses() {
        return repo.findAll();
    }
}