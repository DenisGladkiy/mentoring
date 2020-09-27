package booking.service.impl;

import booking.dao.TicketDao;
import booking.model.Event;
import booking.model.Ticket;
import booking.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DefaultTicketServiceTest {

    private static final String TICKET_ID = "11";

    @Mock
    private TicketDao ticketDao;

    @InjectMocks
    private DefaultTicketService testInstance = new DefaultTicketService();

    @Test
    public void shouldInvokeTicketDaoCreate() {
        testInstance.bookTicket(new User("user"), new Event("event", LocalDate.now()));

        verify(ticketDao).create(any(Ticket.class));
    }

    @Test
    public void shouldInvokeTicketDaoDelete() {
        testInstance.cancelTicket(11);

        verify(ticketDao).delete(TICKET_ID);
    }
}