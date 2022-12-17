import java.util.List;

public class RhombusOrLoop {
    private Integer startGateID;
    private Integer endGateID;
    private List<Kante> kantenList;

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
}
