package booking.dao;

import booking.model.Event;
import booking.model.Model;

import java.util.Map;

public class EventDao implements Dao<Event> {
    private static final String NAMESPACE = "event";
    private Map<String, Model> database;

    @Override
    public void create(Event event) {
        database.put(NAMESPACE + event.getName(), event);
    }

    @Override
    public Event read(String name) {
        return (Event) database.get(NAMESPACE + name);
    }

    @Override
    public void delete(String name) {
        database.remove(NAMESPACE + name);
    }

    public void setDatabase(Map<String, Model> database) {
        this.database = database;
    }
}
