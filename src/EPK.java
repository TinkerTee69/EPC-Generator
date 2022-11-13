import java.util.ArrayList;
import java.util.List;

public class EPK {
    public EPK(int[][] gatePairs, List<Object> gateList_epk, List<Object> fctList_epk, List<Object> evtList_epk, List<Object> epkList) {
        this.gatePairs = gatePairs;
        this.gateList_epk = gateList_epk;
        this.fctList_epk = fctList_epk;
        this.evtList_epk = evtList_epk;
        this.epkList = epkList;
    }

    public EPK() {
        gatePairs = getGatePairs();
        gateList_epk = getGateList_epk();
        fctList_epk = getFctList_epk();
        evtList_epk = getEvtList_epk();
        epkList = buildEPK();

    }
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

    public List<Object> getEpkList() {
        return epkList;
    }

    public void setEpkList(List<Object> epkList) {
        this.epkList = epkList;
    }

    public List<Object> buildEPK(){
        int i = 0;
        int i_gate = 0;
        int i_fct = 0;
        int i_evt = 0;
        while(i < gateList_epk.size())
        {
            if(i==0)
            {
                epkList.add(eventList.getEvtList().get(0));
            }
            i++;
        }
        return epkList;
    }

//    private Event event;
//    private Function function;
    private int[][] gatePairs;
    private List<Object> gateList_epk;
    private List<Object> fctList_epk;
    private List<Object> evtList_epk;
    private List<Object> epkList = new ArrayList<>();
}
