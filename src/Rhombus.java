import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Rhombus extends RhombusOrLoop{

    public Rhombus(Integer kantenIndex, List<Object> list, Integer id, List<Kante> kantenList, Object refStart, Object refEnd) {

//        try{
//            ((Kante) list.get(j)).setEndID(id);
//        }catch(Exception e){};
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i) instanceof Kante)
                if(((Kante) list.get(i)).getKantenID() == kantenIndex)
            {
                super.setId(++id);
                super.setStartGateID(id);
                super.setEndGateID(id+1);
                //setId(id);

                //die 2 neuen Kanten
                ForwardKante kante1 = new ForwardKante(id,id+1, refStart, refEnd);
                ForwardKante kante2 = new ForwardKante(id,id+1, refStart, refEnd);

                list.add(kante1);
                list.add(kante2);

                // Kante vom letzten hinzugefügten Element zum nachfolgendem Element
                ForwardKante kante3 = new ForwardKante(++id, id-2, refStart, refEnd);
                kantenList.add(kante1);
                kantenList.add(kante2);
                kantenList.add(kante3);
                list.add(kante3);

                super.setKantenList(kantenList);
                super.setRefStart(refStart);
                super.setRefEnd(refEnd);

                break;
            }
        }
    }
}
