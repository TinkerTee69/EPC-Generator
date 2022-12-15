public class Kante {
    private Integer startID;
    private Integer endID;
    private Integer kantenID;

    public Kante(Integer startID, Integer endID, Integer kantenID) {
        this.startID = startID;
        this.endID = endID;
        this.kantenID = kantenID;
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
        this.kantenID = kantenID;
    }
}
