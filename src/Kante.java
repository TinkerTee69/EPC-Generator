public class Kante {
    private Integer startID;
    private Integer endID;
    private Integer kantenID = 0;
    private Object refernceStart;
    private Object referenceEnd;

    public Kante(Integer startID, Integer endID) {
        this.startID = startID;
        this.endID = endID;
        kantenID = kantenID();
    }

    public Integer kantenID(){
        setKantenID(kantenID++);
        return getKantenID();
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
        kantenID = this.kantenID++ + 1;
    }
}
