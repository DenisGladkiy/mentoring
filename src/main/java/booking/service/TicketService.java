package booking.service;

import booking.model.Event;
import booking.model.Ticket;
import booking.model.User;

import java.io.IOException;
import java.util.List;

public interface TicketService {
    Ticket bookTicket(User user, Event event);
    Ticket getTicket(int id);
    void cancelTicket(int id);
    List<Ticket> getBookedTickets(String userName, int pageSize, int pageNum);
    void preloadTickets() throws IOException;
}
