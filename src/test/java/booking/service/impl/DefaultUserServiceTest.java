package booking.service.impl;

import booking.dao.UserDao;
import booking.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultUserServiceTest {

    private static final String USER_NAME = "UserName";
    @Mock
    private UserDao userDao;

    @InjectMocks
    private DefaultUserService testInstance = new DefaultUserService();

    @Test
    public void shouldInvokeUserDaoCreate() {
        testInstance.createUser(USER_NAME);

        verify(userDao).create(any(User.class));
    }

    @Test
    public void shouldInvokeUserDaoRead() {
        when(userDao.read(USER_NAME)).thenReturn(new User(USER_NAME));

        testInstance.getUser(USER_NAME);

        verify(userDao).read(USER_NAME);
    }

    @Test
    public void shouldInvokeUserDaoDelete() {
        testInstance.removeUser(USER_NAME);

        verify(userDao).delete(USER_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfUserNotFound() {
        when(userDao.read(USER_NAME)).thenReturn(null);

        testInstance.getUser(USER_NAME);
    }
}