import java.util.List;

public class eventList {


    public eventList() {
    }
    public eventList(List<Object> evtList) {
        this.evtList = evtList;
    }

    public static List<Object> getEvtList() {
        return evtList;
    }

    public static void setEvtList(List<Object> evList) {
        eventList.evtList = evList;
    }

    public static void addElement(Event evtListElement)
    {
        evtList.add(evtListElement);
    }

    private static List<Object> evtList;
}
