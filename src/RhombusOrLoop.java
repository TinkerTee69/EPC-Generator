import java.util.List;

public class RhombusOrLoop {

    public RhombusOrLoop(Integer kantenIndex, List<Object> list, Integer id, List<Kante> kantenList, Object refStart, Object refEnd)
    {
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i) instanceof Kante)
                if(((Kante) list.get(i)).getKantenID() == kantenIndex)
                {
                    ForwardKante kante3 = new ForwardKante(id+2, id, refEnd, ((Kante) list.get(i)).getRefEnd());
                    // von der vorherigen Kante das neue Zielelement ändern
                    ((Kante) list.get(i)).setEndID(id);
                    ((Kante) list.get(i)).setRefEnd(refEnd);

                    this.setId(++id);
                    this.setStartGateID(id);
                    this.setEndGateID(id+1);
                    //setId(id);

                    //die 1 neue Kante (die 2. wird bei Loop / Rhombus hinzugefügt)
                    ForwardKante kante1 = new ForwardKante(id,id+1, refStart, refEnd);


                    list.add(kante1);


                    // Kante vom letzten hinzugefügten Element zum nachfolgendem Element
                    id++;
                    kantenList.add(kante1);

                    kantenList.add(kante3);
                    list.add(kante3);

                    this.setKantenList(kantenList);
                    this.setRefStart(refStart);
                    this.setRefEnd(refEnd);


                    break;
                }
        }

    }
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
