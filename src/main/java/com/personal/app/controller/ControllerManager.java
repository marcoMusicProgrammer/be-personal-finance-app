package com.personal.app.controller;

import com.personal.app.factory.ControllerFactory;
import com.personal.app.factory.ControllerFactoryProvider;

public class ControllerManager {
    
    private GenericController<?> controller;
    private String type;

    public ControllerManager(String defaultType) {
        setController(defaultType);
    }

    public void setController(String type) {
        ControllerFactory<?> factory = ControllerFactoryProvider.getFactory(type);
        this.controller = factory.createController();
        this.type = type;
    }

    public GenericController<?> getController() {
        return controller;
    }

    public String getCurrentType() {
        return type;
    }
}
