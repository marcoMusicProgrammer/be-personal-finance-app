package com.personal.app.controller;

import java.util.List;

import com.personal.app.models.entities.Expense;
import com.personal.app.service.ExpenseService;

import jakarta.servlet.annotation.WebServlet;

@WebServlet(name="expenses",value="/expenses")
public class ExpenseControllerImpl implements GenericController<Expense> {

    private ExpenseService service;

    public ExpenseControllerImpl(ExpenseService service) {
        this.service = service;
    }

    @Override
    public void add(Expense expense) {
        service.addExpense(expense);
    }

    @Override
    public List<Expense> getList() {
        return service.getExpenses();
    }
}
