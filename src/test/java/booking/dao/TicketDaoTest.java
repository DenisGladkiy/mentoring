package booking.dao;

import booking.model.Model;
import booking.model.Ticket;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TicketDaoTest {

    private static final int TICKET_ID = 11;
    private static final String TICKET_KEY = "ticket11";
    private static final int TICKET_PLACE = 11;
    private Ticket ticket;
    private Map<String, Model> database;
    private TicketDao testInstance;

    @Before
    public void setUp() {
        database = new HashMap<>();
        testInstance = new TicketDao();
        testInstance.setDatabase(database);
        ticket = new Ticket(TICKET_ID, TICKET_PLACE);
    }

    @Test
    public void shouldCreateTicketInDatabase() {
        testInstance.create(ticket);

        assertTrue(database.containsKey(TICKET_KEY));
        assertTrue(database.containsValue(ticket));
    }

    @Test
    public void shouldReadTicketFromDatabase() {
        database.put(TICKET_KEY, ticket);

        Ticket result = testInstance.read(String.valueOf(TICKET_ID));

        assertEquals(ticket, result);
    }

    @Test
    public void shouldDeleteTicketFromDatabase() {
        database.put(TICKET_KEY, ticket);

        testInstance.delete(String.valueOf(TICKET_ID));

        assertTrue(database.isEmpty());
    }
}