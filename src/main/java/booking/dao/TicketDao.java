package booking.dao;

import booking.model.Model;
import booking.model.Ticket;

import java.util.Map;

public class TicketDao implements Dao<Ticket> {
    public static final String NAMESPACE = "ticket";
    private Map<String, Model> database;

    @Override
    public void create(Ticket ticket) {
        database.put(NAMESPACE + ticket.getId(), ticket);
    }

    @Override
    public Ticket read(String id) {
        return (Ticket) database.get(NAMESPACE + id);
    }

    @Override
    public void delete(String id) {
        database.remove(NAMESPACE + id);
    }

    public void setDatabase(Map<String, Model> database) {
        this.database = database;
    }
}
