package booking.facade.impl;

import booking.model.Event;
import booking.model.User;
import booking.service.EventService;
import booking.service.TicketService;
import booking.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DefaultBookingFacadeTest {

    private static final String TEST_USER = "TestUser";
    private static final String EVENT = "Event";
    private static final int TICKET_ID = 1;

    @Mock
    private UserService userService;
    @Mock
    private EventService eventService;
    @Mock
    private TicketService ticketService;

    @InjectMocks
    private DefaultBookingFacade testInstance = new DefaultBookingFacade(userService, eventService, ticketService);

    @Test
    public void shouldInvokeUserServiceCreateUser() {
        testInstance.createUser(TEST_USER);

        verify(userService).createUser(TEST_USER);
    }

    @Test
    public void shouldInvokeUserServiceGetUser() {
        testInstance.getUser(TEST_USER);

        verify(userService).getUser(TEST_USER);
    }

    @Test
    public void shouldInvokeEventServiceCreateEvent() {
        LocalDate date = LocalDate.of(2020, 12, 12);

        testInstance.createEvent(EVENT, date);

        verify(eventService).createEvent(EVENT, date);
    }

    @Test
    public void shouldInvokeEventServiceGetEvent() {
        testInstance.getEvent(EVENT);

        verify(eventService).getEvent(EVENT);
    }

    @Test
    public void shouldInvokeTicketServiceBookTicket(){
        User user = new User(TEST_USER);
        Event event = new Event(EVENT, LocalDate.now());

        testInstance.bookTicket(user, event);

        verify(ticketService).bookTicket(user, event);
    }

    @Test
    public void shouldInvokeTicketServiceCancelTicket(){
        testInstance.cancelTicket(TICKET_ID);

        verify(ticketService).cancelTicket(TICKET_ID);
    }
}