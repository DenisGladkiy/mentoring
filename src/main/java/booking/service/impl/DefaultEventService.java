package booking.service.impl;

import booking.dao.Dao;
import booking.exception.ModelNotFoundException;
import booking.model.Event;
import booking.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

public class DefaultEventService implements EventService {

    @Autowired
    private Dao<Event> eventDao;

    @Override
    public Event createEvent(String name, LocalDate date) {
        Event event = new Event(name, date);
        eventDao.create(event);
        return event;
    }

    @Override
    public Event getEvent(String name) throws ModelNotFoundException {
        return Optional.ofNullable(eventDao.read(name))
                .orElseThrow(() -> new ModelNotFoundException("Event with name " + name + "not found"));
    }

    @Override
    public void cancelEvent(String name) {
        eventDao.delete(name);
    }
}
