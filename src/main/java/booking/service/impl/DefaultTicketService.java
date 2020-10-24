package booking.service.impl;

import booking.dao.Dao;
import booking.model.Event;
import booking.model.Ticket;
import booking.model.Tickets;
import booking.model.User;
import booking.service.TicketService;
import booking.utils.Converter;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

public class DefaultTicketService implements TicketService {
    private static Logger log = Logger.getLogger(DefaultTicketService.class.getName());

    private int id = 0;

    @Autowired
    private Dao<Ticket> ticketDao;
    @Autowired
    private Converter converter;
    @Autowired
    private PlatformTransactionManager transactionManager;

    private TransactionTemplate transactionTemplate;

    public DefaultTicketService() {
        transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @Override
    public Ticket bookTicket(User user, Event event) {
        Ticket ticket = new Ticket(id, id++);
        log.info(String.valueOf(id) + " tickets booked");
        ticket.setUser(user);
        ticket.setEvent(event);
        ticketDao.create(ticket);
        return ticket;
    }

    @Override
    public Ticket getTicket(int id) {
        return ticketDao.read(String.valueOf(id));
    }

    @Override
    public void cancelTicket(int id) {
        ticketDao.delete(String.valueOf(id));
        log.info("Ticket with id " + id + " was cancelled");
    }

    @Override
    public List<Ticket> getBookedTickets(String userName, int pageSize, int pageNum) {
        List<Ticket> tickets = ticketDao.readAll(userName);
        List<List<Ticket>> pages = ListUtils.partition(tickets, pageSize);
        return pages.get(pageNum);
    }

    @Override
    public void preloadTickets() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    URL url = getClass().getClassLoader().getResource("./tickets.xml");
                    Tickets tickets = (Tickets) converter.convertToObject(url.getPath());
                    tickets.getTickets().forEach(t -> ticketDao.create(t));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
