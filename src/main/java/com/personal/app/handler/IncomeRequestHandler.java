package com.personal.app.handler;

import java.time.LocalDate;

import com.personal.app.controller.GenericController;
import com.personal.app.factory.IncomeControllerFactory;
import com.personal.app.models.entities.Income;

import javax.servlet.http.HttpServletRequest;

public class IncomeRequestHandler implements RequestHandler<Income> {

    public GenericController<Income> getController() {
        return new IncomeControllerFactory().createController();
    }
 
    public Income buildEntity(HttpServletRequest request) {
        Income i = new Income();
        i.setAmount(Double.parseDouble(request.getParameter("amount")));
        i.setDescription(request.getParameter("description"));
        i.setDate(LocalDate.parse(request.getParameter("date")));
        return i;
    }
    
}
