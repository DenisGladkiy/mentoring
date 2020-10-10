package booking.service;

import booking.exception.ModelNotFoundException;
import booking.model.User;

public interface UserService {
    User createUser(String name);

    User getUser(String name) throws ModelNotFoundException;

    void removeUser(String name);
}
