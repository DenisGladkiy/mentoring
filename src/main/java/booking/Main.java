package booking;

import booking.facade.BookingFacade;
import booking.model.Event;
import booking.model.Model;
import booking.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        BookingFacade facade = (BookingFacade) ctx.getBean("bookingFacade");
        Event event = facade.createEvent("Party", LocalDate.of(2020, 10, 10));
        User user = facade.createUser("Nikola");
        facade.bookTicket(user, event);
        facade.bookTicket(user, event);
        Map<String, Model> database = ctx.getBean("database", Map.class);
        System.out.println(database);
    }
}
