package com.personal.app.models.repositories;

import java.util.List;

public interface BaseRepository <T> {
    void insert(T t);
    List<T> findAll();
}
