package com.melnyk.teammanager.service;

import java.util.Set;

public interface Service<T, ID> {
    T get(ID id);
    T save(T t);
    T update(T t);
    T remove(ID id);
    Set<T> getAll();
}
