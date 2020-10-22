package booking.controller;

import booking.exception.ModelNotFoundException;
import booking.facade.BookingFacade;
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

import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private BookingFacade bookingFacade;

    @GetMapping("/{name}")
    public String getUser(@PathVariable String name, Model model) throws ModelNotFoundException {
        User user = bookingFacade.getUser(name);
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody Map<String, String> params){
        bookingFacade.createUser(params.get("username"));
    }
}
