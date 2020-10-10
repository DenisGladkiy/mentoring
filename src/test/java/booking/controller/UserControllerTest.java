package booking.controller;

import booking.exception.ModelNotFoundException;
import booking.facade.BookingFacade;
import booking.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private static final String NAME = "Name";
    @Mock
    private BookingFacade bookingFacade;
    @Mock
    private Model model;
    @Mock
    private User user;

    @InjectMocks
    private UserController testInstance;

    @Before
    public void setUp() throws ModelNotFoundException {
        when(bookingFacade.getUser(NAME)).thenReturn(user);
    }

    @Test
    public void shouldAddUserToModel() throws ModelNotFoundException {
        testInstance.getUser(NAME, model);

        verify(model).addAttribute("user", user);
    }

    @Test
    public void shouldInvokeBookingFacadeCreateUser(){
        testInstance.createUser(Collections.singletonMap("username", NAME));

        verify(bookingFacade).createUser(NAME);
    }
}