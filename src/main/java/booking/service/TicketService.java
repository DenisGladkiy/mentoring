package booking.service;

import booking.model.Event;
import booking.model.Ticket;
import booking.model.User;

public interface TicketService {
    Ticket bookTicket(User user, Event event);
    void cancelTicket(int id);
}
