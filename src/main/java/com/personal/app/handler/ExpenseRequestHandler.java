package com.personal.app.handler;

import com.personal.app.controller.GenericController;
import com.personal.app.factory.ExpenseControllerFactory;
import com.personal.app.models.entities.Expense;

import javax.servlet.http.HttpServletRequest;

public class ExpenseRequestHandler implements RequestHandler<Expense> {

    public GenericController<Expense> getController() {
        return new ExpenseControllerFactory().createController();
    }

    public Expense buildEntity(HttpServletRequest request) {
        Expense e = new Expense();
        e.setAmount(Double.parseDouble(request.getParameter("amount")));
        e.setDescription(request.getParameter("description"));
        return e;
    }
    
}
