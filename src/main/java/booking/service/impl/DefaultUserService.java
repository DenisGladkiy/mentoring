package booking.service.impl;

import booking.dao.Dao;
import booking.exception.ModelNotFoundException;
import booking.model.User;
import booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DefaultUserService implements UserService {

    @Autowired
    private Dao<User> userDao;

    @Override
    public User createUser(String name) {
        User user = new User(name);
        userDao.create(user);
        return user;
    }

    @Override
    public User getUser(String name) throws ModelNotFoundException {
        return Optional.ofNullable(userDao.read(name))
                .orElseThrow(() -> new ModelNotFoundException("User with name " + name + "not found"));
    }

    @Override
    public void removeUser(String name) {
        userDao.delete(name);
    }
}
