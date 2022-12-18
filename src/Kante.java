public class Kante {
    private Integer startID;
    private Integer endID;
    private static Integer counter = 0;
    private Integer kantenID;
    private Object refStart;
    private Object refEnd;

    public Kante(Integer startID, Integer endID, Object refStart, Object refEnd) {
        this.startID = startID;
        this.endID = endID;
        setCounter(++counter);
        setKantenID(getCounter());
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
        this.kantenID = kantenID;
    }

    public static Integer getCounter() {
        return counter;
    }

    public static void setCounter(Integer counter) {
        Kante.counter = counter;
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
}
