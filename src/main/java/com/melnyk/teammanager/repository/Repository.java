package com.melnyk.teammanager.repository;

import java.util.Set;

public interface Repository<T, ID> {
    T getById(ID id);
    T add(T t);
    T update(T t);
    T removeById(ID id);

    Set<T> getAll();
}
