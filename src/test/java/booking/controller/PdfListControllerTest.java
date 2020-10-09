package booking.controller;

import booking.facade.BookingFacade;
import booking.model.Ticket;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PdfListControllerTest {

    private static final String NAME = "Name";

    @Mock
    private BookingFacade bookingFacade;
    @Mock
    private Ticket ticket;

    @InjectMocks
    private PdfListController testInstance;

    @Before
    public void setUp() {
        when(bookingFacade.getBookedTickets(NAME, 5, 5)).thenReturn(Collections.singletonList(ticket));
    }

    @Test
    public void shouldReturnModelAndView() {
        ModelAndView result = testInstance.getTickets(NAME, 5, 5);

        List<Ticket> tickets = (List<Ticket>) result.getModel().get("Tickets");

        assertEquals(ticket, tickets.get(0));
    }
}