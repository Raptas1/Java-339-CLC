package com.gcu.data;

import java.util.List;

public interface ListingsAccessInterface <T>{
    public List<T> findAll();
    public T findById(int id);
    public List<T> findByUser_Id(Long id);
    public boolean create (T t);
    public boolean update(T t);
    public boolean delete(T t);
}
