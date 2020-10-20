package booking.facade;

import booking.model.Event;
import booking.model.Ticket;
import booking.model.User;

import java.time.LocalDate;

public interface BookingFacade {
 User createUser(String name);
 User getUser(String name);
 Event createEvent(String name, LocalDate date);
 Event getEvent(String name);
 Ticket bookTicket(User user, Event event);
 void cancelTicket(int id);
}
