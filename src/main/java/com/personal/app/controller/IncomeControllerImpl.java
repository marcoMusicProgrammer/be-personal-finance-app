package com.personal.app.controller;

import java.util.List;

import com.personal.app.models.entities.Income;
import com.personal.app.service.IncomeService;

public class IncomeControllerImpl implements GenericController<Income> {

	private IncomeService service;

	public IncomeControllerImpl(IncomeService service) {
		this.service = service;
	}

	@Override
	public void add(Income income) {
		service.addIncome(income);
	}

	@Override
	public List<Income> getList() {
		return service.getIncomes();
	}
    
}
