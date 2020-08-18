package com.prometheus.crud;

public interface CrudRepository <T> { // genericke
    void create (T entita);
    T read(Class<T> entityClass, Object id);
    T update(T entita);
    void delete(T entita);
}
