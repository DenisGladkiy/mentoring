package booking.controller;

import booking.exception.ModelNotFoundException;
import booking.facade.BookingFacade;
import booking.model.Event;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventControllerTest {

    private static final String NAME = "Name";
    private static final String DATE = "2010-10-10";
    @Mock
    private BookingFacade bookingFacade;
    @Mock
    private Model model;
    @Mock
    private Event event;

    @InjectMocks
    private EventController testInstance;

    @Before
    public void setUp() throws ModelNotFoundException {
        when(bookingFacade.getEvent(NAME)).thenReturn(event);
    }

    @Test
    public void shouldAddEventToModel() throws ModelNotFoundException {
        testInstance.getEvent(NAME, model);

        verify(model).addAttribute("event", event);
    }

    @Test
    public void shouldInvokeBookingFacadeCreateEvent() {
        testInstance.createEvent(NAME, DATE);

        verify(bookingFacade).createEvent(NAME, LocalDate.of(2010, 10, 10));
    }
}