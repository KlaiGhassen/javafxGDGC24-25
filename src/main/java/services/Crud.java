package services;

import java.util.List;

public interface Crud<T> {
    public void insert(T obj) throws Exception;

    public void update(T obj) throws Exception;

    public void delete(T obj) throws Exception;

    public List<T> find() throws Exception;

}
