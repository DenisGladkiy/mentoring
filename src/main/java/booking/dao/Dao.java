package booking.dao;

import java.util.List;

public interface Dao<T> {
    void create(T t);

    T read(String id);

    void delete(String id);

    List<T> readAll(String name);
}
