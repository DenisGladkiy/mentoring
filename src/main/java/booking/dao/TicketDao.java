package booking.dao;

import booking.model.Model;
import booking.model.Ticket;
import booking.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<Ticket> readAll(String userName) {
        return database.entrySet().stream()
                .map(entry -> (Ticket) entry.getValue())
                .filter(ticket -> isUserWithName(ticket, userName))
                .collect(Collectors.toList());

    }

    private Boolean isUserWithName(Ticket ticket, String name){
        return Optional.ofNullable(ticket.getUser())
                .map(User::getName)
                .map(s -> s.equals(name))
                .orElse(false);
    }

    public void setDatabase(Map<String, Model> database) {
        this.database = database;
    }
}
