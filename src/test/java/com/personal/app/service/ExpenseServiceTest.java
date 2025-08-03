package com.personal.app.service;

import com.personal.app.models.entities.Expense;
import com.personal.app.models.repositories.BaseRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ExpenseServiceTest {
    private BaseRepository<Expense> mockRepo;
    private ExpenseService service;

    @SuppressWarnings("unchecked")
	@BeforeEach
    void setUp() {
        mockRepo = mock(BaseRepository.class);
        service = new ExpenseService(mockRepo);
    }

    @Test
    void testAddExpense() {
        Expense expense = new Expense("prova",89.9);
        service.addExpense(expense);
        verify(mockRepo,times(1)).insert(any(Expense.class));
    }

}
