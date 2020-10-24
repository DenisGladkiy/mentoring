package booking.service.impl;

import booking.dao.EventDao;
import booking.exception.ModelNotFoundException;
import booking.model.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultEventServiceTest {

    private static final String EVENT_NAME = "EventName";

    @Mock
    private EventDao eventDao;

    @InjectMocks
    private DefaultEventService testInstance = new DefaultEventService();

    @Test
    public void shouldInvokeEventDaoCreate() {
        testInstance.createEvent(EVENT_NAME, LocalDate.now());

        verify(eventDao).create(any(Event.class));
    }

    @Test
    public void shouldInvokeEventDaoRead() throws ModelNotFoundException {
        when(eventDao.read(EVENT_NAME)).thenReturn(new Event(EVENT_NAME, LocalDate.now()));

        testInstance.getEvent(EVENT_NAME);

        verify(eventDao).read(EVENT_NAME);
    }

    @Test
    public void shouldInvokeEventDaoDelete() {
        testInstance.cancelEvent(EVENT_NAME);

        verify(eventDao).delete(EVENT_NAME);
    }

    @Test(expected = ModelNotFoundException.class)
    public void shouldThrowExceptionIfEventNotFound() throws ModelNotFoundException {
        when(eventDao.read(EVENT_NAME)).thenReturn(null);

        testInstance.getEvent(EVENT_NAME);
    }
}