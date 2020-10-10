package booking.service;

import booking.exception.ModelNotFoundException;
import booking.model.Event;

import java.time.LocalDate;

public interface EventService {
    Event createEvent(String name, LocalDate date);

    Event getEvent(String name) throws ModelNotFoundException;

    void cancelEvent(String name);
}
