package com.personal.app.service;

import java.util.List;

import com.personal.app.models.entities.Income;
import com.personal.app.models.repositories.BaseRepository;

public class IncomeService {

    private final BaseRepository<Income> repo;
    
    public IncomeService(BaseRepository<Income> repository) {
        this.repo = repository;
    }

    public void addIncome(Income income) {
        if (income.getAmount() < 0) throw new IllegalArgumentException("Income amount cannot be negative");
        repo.insert(income);
    }

    public List<Income> getIncomes() {
        return repo.findAll();
    }
}
