import java.util.List;

public class RhombusOrLoop {
    private Integer startGateID;
    private Integer endGateID;
    private List<Kante> kantenList;
    private Object refStart;
    private Object refEnd;
    private Integer id;

    public Integer getStartGateID() {
        return startGateID;
    }

    public void setStartGateID(Integer startGateID) {
        this.startGateID = startGateID;
    }

    public Integer getEndGateID() {
        return endGateID;
    }

    public void setEndGateID(Integer endGateID) {
        this.endGateID = endGateID;
    }

    public List<Kante> getKantenList() {
        return kantenList;
    }

    public void setKantenList(List<Kante> kantenList) {
        this.kantenList = kantenList;
    }

    protected void setId(Integer id) {
        this.id = id;
    }

    public Object getRefStart() {
        return refStart;
    }

    public void setRefStart(Object refStart) {
        this.refStart = refStart;
    }

    public Object getRefEnd() {
        return refEnd;
    }

    public void setRefEnd(Object refEnd) {
        this.refEnd = refEnd;
    }

    public Integer getId() {
        return id;
    }
}
