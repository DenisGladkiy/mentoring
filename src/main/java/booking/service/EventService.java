package booking.service;

import booking.model.Event;

import java.time.LocalDate;

public interface EventService {
    Event createEvent(String name, LocalDate date);

    Event getEvent(String name);

    void cancelEvent(String name);
}
