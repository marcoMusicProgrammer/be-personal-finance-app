package com.personal.app.factory;

public class ControllerFactoryProvider {

    public static ControllerFactory<?> getFactory(String type) {
        return switch(type.toLowerCase()) {
            case "expense" -> new ExpenseControllerFactory();
            case "income" -> new IncomeControllerFactory();
            default -> throw new IllegalArgumentException("Unkown controller type: "+type);
        };
    }
}
