package com.personal.app.controller;

import java.util.List;

public interface GenericController<T> {
    void add(T t);
    List<T> getList();
}
