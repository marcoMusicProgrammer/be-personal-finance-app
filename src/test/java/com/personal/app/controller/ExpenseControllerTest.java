package com.personal.app.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.personal.app.models.entities.Expense;
import com.personal.app.service.ExpenseService;

public class ExpenseControllerTest {
    private ExpenseService mockService;
    private ExpenseControllerImpl controller;

    @BeforeEach
    void setUp() {
        mockService = mock(ExpenseService.class);
        controller = new ExpenseControllerImpl(mockService);
    }

    @Test
    void testAddExpenseTest() {
        Expense expense = new Expense("uanm",87.7);
        controller.add(expense);
        verify(mockService,times(1)).addExpense(expense);
        
    }




}
