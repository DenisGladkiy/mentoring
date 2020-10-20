package booking.service;

import booking.model.User;

public interface UserService {
    User createUser(String name);

    User getUser(String name);

    void removeUser(String name);
}
