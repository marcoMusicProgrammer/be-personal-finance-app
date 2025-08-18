package com.personal.app.handler;

import com.personal.app.controller.GenericController;

import javax.servlet.http.HttpServletRequest;

public interface RequestHandler<T> {
    GenericController<T> getController();
    T buildEntity(HttpServletRequest request);
}
