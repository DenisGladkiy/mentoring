package booking.controller;

import booking.facade.BookingFacade;
import booking.model.Event;
import booking.model.Ticket;
import booking.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.Map;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TicketControllerTest {

    private static final int ID = 1;
    private static final String NAME = "name";
    @Mock
    private BookingFacade bookingFacade;
    @Mock
    private Model model;
    @Mock
    private Ticket ticket;

    @InjectMocks
    private TicketController testInstance;

    @Before
    public void setUp() {
        when(bookingFacade.getTicket(ID)).thenReturn(ticket);
    }

    @Test
    public void shouldAddTicketToModel() {
        testInstance.getTicket(ID, model);

        verify(model).addAttribute("ticket", ticket);
    }

    @Test
    public void shouldInvokeBookingFacadeBookTicket() {
        testInstance.bookTicket(Map.of("username", NAME, "eventname", NAME, "date", "2010-10-10"));

        verify(bookingFacade).bookTicket(any(User.class), any(Event.class));
    }

    @Test
    public void shouldInvokeBookingFacadeCancelTicket() {
        testInstance.cancelTicket(Map.of("id", "1"));

        verify(bookingFacade).cancelTicket(ID);
    }

}