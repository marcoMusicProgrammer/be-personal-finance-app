package com.personal.app.factory;

import com.personal.app.controller.GenericController;

public abstract class ControllerFactory<T> {
    public abstract GenericController<T> createController();
}
