package booking.dao;

import booking.model.Event;
import booking.model.Model;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EventDaoTest {

    private static final String EVENT_NAME = "EventName";
    private static final String EVENT_KEY = "eventEventName";
    private EventDao testInstance;
    private Event event;
    private Map<String, Model> database;

    @Before
    public void setUp() {
        database = new HashMap<>();
        testInstance = new EventDao();
        testInstance.setDatabase(database);
        event = new Event(EVENT_NAME, LocalDate.now());
    }

    @Test
    public void shouldCreateEventInDatabase() {
        testInstance.create(event);

        assertTrue(database.containsKey(EVENT_KEY));
        assertTrue(database.containsValue(event));
    }

    @Test
    public void shouldReadEventFromDatabase() {
        database.put(EVENT_KEY, event);

        Event result = testInstance.read(EVENT_NAME);

        assertEquals(event, result);
    }

    @Test
    public void shouldDeleteEventFromDatabase() {
        database.put(EVENT_KEY, event);

        testInstance.delete(EVENT_NAME);

        assertTrue(database.isEmpty());
    }
}