package booking.controller;

import booking.facade.BookingFacade;
import booking.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PdfListController {

    @Autowired
    private BookingFacade bookingFacade;

    @RequestMapping(value = "/tickets/{userName}/pageSize/{size}/pageNumber/{number}", method = RequestMethod.GET,
            produces = "application/pdf")
    public ModelAndView getTickets(@PathVariable String name, @PathVariable int size, @PathVariable int number) {
        List<Ticket> bookedTickets = bookingFacade.getBookedTickets(name, size, number);
        return new ModelAndView("tickets", "Tickets", bookedTickets);
    }
}
