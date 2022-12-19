import java.util.List;

public class RhombusOrLoop {

    public RhombusOrLoop(Integer kantenIndex, List<Object> list, Integer id, List<Kante> kantenList, Object refStart, Object refEnd)
    {
        //Durchlaufen des EPKs, bis die zufällig ausgewählte Kante gefunden wurde
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i) instanceof Kante)
                if(((Kante) list.get(i)).getKantenID() == kantenIndex)
                {
                    //letzte Kante (von dem 2. Element des Rhombus/Loops zu dem vorherigen Endelement)
                    ForwardKante kante3 = new ForwardKante(id+2, id, refEnd, ((Kante) list.get(i)).getRefEnd());
                    list.add(kante3);
                    kantenList.add(kante3);

                    // von der vorherigen Kante das neue Zielelement ändern (zu dem neu zu erstellenden Rhombus/Loop)
                    ((Kante) list.get(i)).setEndID(++id);
                    ((Kante) list.get(i)).setRefEnd(refStart);

                    //Setzten der IDs des neuen Rhombus/Loops
                    this.setId(id);
                    this.setStartGateID(id);
                    this.setEndGateID(id+1);
                    this.setKantenList(kantenList);
                    this.setRefStart(refStart);
                    this.setRefEnd(refEnd);

                    //die 1 neue Kante (die 2. wird bei der Klasse Rhombus bzw. Loop hinzugefügt)
                    ForwardKante kante1 = new ForwardKante(id,id+1, refStart, refEnd);
                    list.add(kante1);
                    kantenList.add(kante1);

                    id++;
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
