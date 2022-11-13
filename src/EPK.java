import java.util.ArrayList;
import java.util.List;

public class EPK {
//    public Event getEvent() {
//        return event;
//    }
//
//    public void setEvent(Event event) {
//        this.event = event;
//    }
//
//    public Function getFunction() {
//        return function;
//    }
//
//    public void setFunction(Function function) {
//        this.function = function;
//    }

    public void setGateList_epk(gateList gateList_epk) {
        this.gateList_epk = gateList.getGateList();
    }

    public void setGatePairs(int[][] gatePairs) {
        this.gatePairs = randomTree2.getGatePairs();
    }


    public int[][] getGatePairs() {
        return gatePairs;
    }

    public List<Object> getGateList_epk() {
        return gateList.getGateList();
    }

    public List getFctList_epk() {
        return functionList.getFctList();
    }

    public void setFctList_epk(List fctList_epk) {
        this.fctList_epk = fctList_epk;
    }

    public List getEvtList_epk() {
        return eventList.getEvtList();
    }

    public void setEvtList_epk(List evtList_epk) {
        this.evtList_epk = evtList_epk;
    }

//    private Event event;
//    private Function function;
    private int[][] gatePairs;
    private List gateList_epk;
    private List fctList_epk;
    private List evtList_epk;
}
