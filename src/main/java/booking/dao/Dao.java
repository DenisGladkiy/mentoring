package booking.dao;

public interface Dao<T> {
    void create(T t);

    T read(String id);

    void delete(String id);
}
