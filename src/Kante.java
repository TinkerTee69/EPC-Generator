public class Kante {
    private Integer startID;
    private Integer endID;
    private static Integer kantenID = 0;
    private Object refStart;
    private Object refEnd;

    public Kante(Integer startID, Integer endID, Object refStart, Object refEnd) {
        this.startID = startID;
        this.endID = endID;
        setKantenID(kantenID++);
        kantenID = getKantenID();
        this.refStart = refStart;
        this.refEnd = refEnd;
    }



    public Integer getStartID() {
        return startID;
    }

    public void setStartID(Integer startID) {
        this.startID = startID;
    }

    public Integer getEndID() {
        return endID;
    }

    public void setEndID(Integer endID) {
        this.endID = endID;
    }

    public Integer getKantenID() {
        return kantenID;
    }

    public void setKantenID(Integer kantenID) {
        kantenID = this.kantenID;
    }
}
