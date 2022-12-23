public class Event extends EPK_Element{
    private Integer id;
    private String eventText;

    public Event(Integer position, Integer level, String text) {
        super(position, level);
        this.eventText = text;
    }

    public Event(){super();}


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
