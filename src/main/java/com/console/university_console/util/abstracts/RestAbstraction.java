package com.console.university_console.util.abstracts;

import java.util.List;

public interface RestAbstraction<T> {
    T create(T entity);
    T remove(String entityId);
    T update(String entityId, T entity);
    List<T> getAll();
    T getOne(String entityId);
}
