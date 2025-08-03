package com.personal.app.factory;

import com.personal.app.controller.ExpenseControllerImpl;
import com.personal.app.controller.GenericController;
import com.personal.app.models.entities.Expense;
import com.personal.app.models.repositories.ExpenseRepositoryImpl;
import com.personal.app.service.ExpenseService;

public class ExpenseControllerFactory extends ControllerFactory<Expense> {
    public GenericController<Expense> createController() {
        var repository = ExpenseRepositoryImpl.getInstance();
        var service = new ExpenseService(repository);
        return new ExpenseControllerImpl(service);
    }
}