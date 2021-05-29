package ru.geekbrains.erpsystem.services;

import java.util.List;
import java.util.Optional;

public interface CrudService <T,ID>{
    T insert(T var1);
    T update(T var1);
    void delete(ID var1);
    Optional<T> getById(ID var1);
    List<T> getAll();
}
