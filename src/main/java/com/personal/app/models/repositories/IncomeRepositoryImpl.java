package com.personal.app.models.repositories;

import java.util.List;

import com.personal.app.models.entities.Income;

public class IncomeRepositoryImpl extends GenericRepository<Income> {
    
    private static IncomeRepositoryImpl instance;

    public static IncomeRepositoryImpl getInstance() {
        if(instance == null) {
            instance = new IncomeRepositoryImpl();
        }
        return instance;
    }

    private IncomeRepositoryImpl() {
        super(Income.class);
    }

    @Override
    public void insert(Income income) {
        super.insert(income);
    }

    @Override
    public List<Income> findAll() {
        return super.findAll();
    }

}
