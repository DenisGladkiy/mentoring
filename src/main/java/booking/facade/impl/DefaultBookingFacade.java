package booking.facade.impl;

import booking.facade.BookingFacade;
import booking.model.Event;
import booking.model.Ticket;
import booking.model.User;
import booking.service.EventService;
import booking.service.TicketService;
import booking.service.UserService;

import java.time.LocalDate;
import java.util.List;

public class DefaultBookingFacade implements BookingFacade {
    private UserService userService;
    private EventService eventService;
    private TicketService ticketService;

    public DefaultBookingFacade(UserService userService, EventService eventService,
                                TicketService ticketService) {
        this.userService = userService;
        this.eventService = eventService;
        this.ticketService = ticketService;
    }

    @Override
    public User createUser(String name) {
        return userService.createUser(name);
    }

    @Override
    public User getUser(String name) {
        return userService.getUser(name);
    }

    @Override
    public Event createEvent(String name, LocalDate date) {
        return eventService.createEvent(name, date);
    }

    @Override
    public Event getEvent(String name) {
        return eventService.getEvent(name);
    }

    @Override
    public Ticket bookTicket(User user, Event event) {
        return ticketService.bookTicket(user, event);
    }

    @Override
    public Ticket getTicket(int id){
        return ticketService.getTicket(id);
    }

    @Override
    public void cancelTicket(int id) {
        ticketService.cancelTicket(id);
    }

    @Override
    public List<Ticket> getBookedTickets(String userName, int pageSize, int pageNum) {
        return ticketService.getBookedTickets(userName, pageSize, pageNum);
    }
}
