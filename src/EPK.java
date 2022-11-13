import java.util.ArrayList;
import java.util.List;

public class EPK {
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public List<Integer> getTypeGate() {
        return typeGate;
    }

    public void setTypeGate(List<Integer> typeGate) {
        this.typeGate = typeGate;
    }

    private Event event;
    private Function function;
    private List<Integer> typeGate = new ArrayList<>();
    private gateList gateList_epk;
    private int[][] gatePairs;

    public List<Object> getGateList_epk() {
        return gateList.getGateList();
    }
}
