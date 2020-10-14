package service;

import java.util.ArrayList;

public interface Method<T> {
    void add(T object);

    void delete(int id);

    ArrayList<T> seachByName(String name);

    T seachById(int id);

}
