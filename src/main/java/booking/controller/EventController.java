package booking.controller;

import booking.facade.BookingFacade;
import booking.model.Event;
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
@RequestMapping("/event")
public class EventController {

    @Autowired
    private BookingFacade bookingFacade;

    @GetMapping("/{name}")
    public String getEvent(@PathVariable String name, Model model) {
        Event event = bookingFacade.getEvent(name);
        model.addAttribute("event", event);
        return "event";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody Map<String, String> params){
        bookingFacade.createEvent(params.get("eventname"), LocalDate.parse(params.get("date")));
    }
}
