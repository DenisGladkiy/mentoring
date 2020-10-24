package booking.controller;

import booking.exception.ModelNotFoundException;
import booking.facade.BookingFacade;
import booking.model.Event;
import booking.service.impl.DefaultTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@ControllerAdvice
@RequestMapping("/events")
public class EventController {
    private static Logger log = Logger.getLogger(EventController.class.getName());

    @Autowired
    private BookingFacade bookingFacade;

    @GetMapping("/{name}")
    public String getEvent(@PathVariable String name, Model model) throws ModelNotFoundException {
        Event event = bookingFacade.getEvent(name);
        model.addAttribute("event", event);
        return "event";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEvent(@RequestParam(value="eventname") String eventname, @RequestParam(value="date") String date){
        bookingFacade.createEvent(eventname, LocalDate.parse(date));
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ModelAndView ModelNotFoundExceptionHandler(Exception ex) {
        log.info("Exception" + ex.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
