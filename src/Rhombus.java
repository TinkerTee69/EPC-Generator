import java.util.List;
import java.util.Random;

public class Rhombus extends RhombusOrLoop{

    private Object GateType;

    public Rhombus(Integer kantenIndex, List<Object> list, Integer id, List<Kante> kantenList) {

//        try{
//            ((Kante) list.get(j)).setEndID(id);
//        }catch(Exception e){};

        //die 2 neuen Kanten
        ForwardKante kante1 = new ForwardKante(id,id+1);
        ForwardKante kante2 = new ForwardKante(id,id+1);

        list.add(kante1);
        list.add(kante2);

        // Kante vom letzten hinzugefügten Element zum nachfolgendem Element
        Kante kante3 = new Kante(++id, id-2);
        kantenList.add(kante1);
        kantenList.add(kante2);
        kantenList.add(kante3);
        list.add(kante3);

        super.setKantenList(kantenList);
    }

}
