package booking.dao;

import booking.model.Model;
import booking.model.User;

import java.util.Map;

public class UserDao implements Dao<User> {
    private static final String NAMESPACE = "user";
    private Map<String, Model> database;

    @Override
    public void create(User user) {
        database.put(NAMESPACE + user.getName(), user);
    }

    @Override
    public User read(String name) {
        return (User) database.get(NAMESPACE + name);
    }

    @Override
    public void delete(String name) {
        database.remove(NAMESPACE + name);
    }

    public void setDatabase(Map<String, Model> database) {
        this.database = database;
    }
}
