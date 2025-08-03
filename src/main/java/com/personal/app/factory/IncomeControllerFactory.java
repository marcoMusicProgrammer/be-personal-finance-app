package com.personal.app.factory;

import com.personal.app.controller.GenericController;
import com.personal.app.controller.IncomeControllerImpl;
import com.personal.app.models.entities.Income;
import com.personal.app.models.repositories.IncomeRepositoryImpl;
import com.personal.app.service.IncomeService;

public class IncomeControllerFactory extends ControllerFactory<Income> {

    public GenericController<Income> createController() {
        return new IncomeControllerImpl(
            new IncomeService(IncomeRepositoryImpl.getInstance())
        );
    }
    
}
