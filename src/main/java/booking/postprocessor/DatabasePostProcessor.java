package booking.postprocessor;

import booking.model.Event;
import booking.model.Ticket;
import booking.model.User;
import booking.service.TicketService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.MapFactoryBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class DatabasePostProcessor implements BeanPostProcessor {

    private String initialValuesPath;
    private TicketService ticketService;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MapFactoryBean) {
            initializeDatabase((MapFactoryBean) bean);
            try {
                ticketService.preloadTickets();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }

    private void initializeDatabase(MapFactoryBean bean) {
        MapFactoryBean mapFactoryBean = bean;
        Map<Object, Object> database = null;
        try {
            database = mapFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File(initialValuesPath)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line.startsWith("user")) {
                String[] strings = line.split(";");
                database.put(strings[0], new User(strings[1]));
            }
            if (line.startsWith("event")) {
                String[] strings = line.split(";");
                database.put(strings[0], new Event(strings[1], LocalDate.parse(strings[2], formatter)));
            }
            if (line.startsWith("ticket")) {
                String[] strings = line.split(";");
                database.put(strings[0], new Ticket(Integer.parseInt(strings[1]), Integer.parseInt(strings[2])));
            }
        }
    }

    public void setInitialValuesPath(String initialValuesPath) {
        this.initialValuesPath = initialValuesPath;
    }

    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }
}
