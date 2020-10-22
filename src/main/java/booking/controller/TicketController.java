package booking.controller;

import booking.facade.BookingFacade;
import booking.model.Event;
import booking.model.Ticket;
import booking.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private BookingFacade bookingFacade;

    @GetMapping("/{id}")
    public String getTicket(@PathVariable int id, Model model) {
        Ticket ticket = bookingFacade.getTicket(id);
        model.addAttribute("ticket", ticket);
        return "ticket";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void bookTicket(@RequestBody Map<String, String> params) {
        User user = new User(params.get("username"));
        Event event = new Event(params.get("eventname"), LocalDate.parse(params.get("date")));
        bookingFacade.bookTicket(user, event);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void cancelTicket(@RequestBody Map<String, String> params) {
        bookingFacade.cancelTicket(Integer.parseInt(params.get("id")));
    }
}
