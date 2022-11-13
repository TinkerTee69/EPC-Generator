public class Event {
    Integer position;

    public Event() {
    }

    public Event(Integer position, String eventText) {
        this.position = position;
        this.eventText = eventText;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getEventText() {
        return eventText;
    }

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }

    String eventText;
}
