public class Event {
    private Integer id;
    private String eventText;

    public Event() {
    }

    public Event(Integer id, String eventText) {
        this.id = id;
        this.eventText = eventText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventText() {
        return eventText;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }


}
