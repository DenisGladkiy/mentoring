package booking.facade;

import booking.model.Event;
import booking.model.Ticket;
import booking.model.User;

import java.time.LocalDate;
import java.util.List;

public interface BookingFacade {
 User createUser(String name);
 User getUser(String name);
 Event createEvent(String name, LocalDate date);
 Event getEvent(String name);
 Ticket bookTicket(User user, Event event);
 Ticket getTicket(int id);
 void cancelTicket(int id);
 List<Ticket> getBookedTickets(String userName, int pageSize, int pageNum);
}