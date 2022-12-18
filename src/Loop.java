import java.util.List;

public class Loop extends RhombusOrLoop{
    public Loop(Integer kantenIndex, List<Object> list, Integer id, List<Kante> kantenList, Object refStart, Object refEnd){
        //die 2 neuen Kanten
        ForwardKante kante1 = new ForwardKante(id,id+1,refStart, refEnd);
        backwardKante kante2 = new backwardKante(id,id+1, refStart, refEnd);

        list.add(kante1);
        list.add(kante2);

        // Kante vom letzten hinzugefügten Element zum nachfolgendem Element
        Kante kante3 = new Kante(++id, id-2, refStart, refEnd);
        kantenList.add(kante1);
        kantenList.add(kante2);
        kantenList.add(kante3);
        list.add(kante3);
    }
}
