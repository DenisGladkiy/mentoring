package booking.dao;

import booking.model.Model;
import booking.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserDaoTest {

    private static final String USER_NAME = "UserName";
    private static final String USER_KEY = "userUserName";
    private UserDao testInstance;
    private User user;
    private Map<String, Model> database;

    @Before
    public void setUp() {
        database = new HashMap<>();
        testInstance = new UserDao();
        testInstance.setDatabase(database);
        user = new User(USER_NAME);
    }

    @Test
    public void shouldCreateUserInDatabase() {
        testInstance.create(user);

        assertTrue(database.containsKey(USER_KEY));
        assertTrue(database.containsValue(user));
    }

    @Test
    public void shouldReadUserFromDatabase() {
        database.put(USER_KEY, user);

        User result = testInstance.read(USER_NAME);

        assertEquals(user, result);
    }

    @Test
    public void shouldDeleteUserFromDatabase() {
        database.put(USER_KEY, user);

        testInstance.delete(USER_NAME);

        assertTrue(database.isEmpty());
    }
}