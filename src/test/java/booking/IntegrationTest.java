package booking;

import booking.facade.BookingFacade;
import booking.model.Event;
import booking.model.Model;
import booking.model.Ticket;
import booking.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntegrationTest {

    private BookingFacade facade;
    private Map<String, Model> database;

    @Before
    public void setUp() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        facade = applicationContext.getBean("bookingFacade", BookingFacade.class);
        database = applicationContext.getBean("database", Map.class);
    }

    @Test
    public void shouldContainBookedTicketInDatabase() {
        User user = facade.createUser("Semen");
        Event event = facade.createEvent("Concert", LocalDate.of(2021, 01, 01));
        Ticket ticket = facade.bookTicket(user, event);

        assertTrue(database.containsKey("ticket0"));
        Ticket ticket1 = (Ticket) database.get("ticket0");
        assertEquals(ticket, ticket1);
    }

    @Test
    public void shouldRemoveTicketFromDatabase() {
        User user = facade.createUser("Semen");
        Event event = facade.createEvent("Concert", LocalDate.of(2021, 01, 01));
        facade.bookTicket(user, event);

        facade.cancelTicket(0);

        assertFalse(database.containsKey("ticket0"));
    }
}
