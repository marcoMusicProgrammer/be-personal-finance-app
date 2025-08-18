package com.personal.app.handler;

import java.util.Map;

public class HandlerRegistry {
    private static final Map<String,RequestHandler<?>> handlers = Map.of(
        "income", new IncomeRequestHandler(),
        "expense", new ExpenseRequestHandler()
    );

    public static RequestHandler<?> getHandler(String type) {
        return handlers.get(type.toLowerCase());
    }
    
}
