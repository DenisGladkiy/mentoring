package booking.model;

public class Ticket implements Model {
    private int id;
    private int place;
    private User user;
    private Event event;

    public Ticket(int id, int place) {
        this.id = id;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public int getPlace() {
        return place;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
