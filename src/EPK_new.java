import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EPK_new {

    List<Kante> kantenList = new ArrayList<>();
    List<Object> list = new ArrayList<>();

    public EPK_new(Parameters parameters) {
        Integer amountLoops = parameters.getLoops();
        Integer amountRhombus = parameters.getRhomben();
        int i = 0;
        int i_rhombus = amountRhombus;
        int i_loop = amountLoops;
        int kantenIndex;
        Integer id = 0;

        //Erzeugung zweier Startelemente
        Event evt = new Event(++id, "Event Text");
        EPK_Element startElement = new EPK_Element(0,0, evt, id, evt.getEventText());
        Function fct = new Function(++id, "Function Text");
        EPK_Element endElement = new EPK_Element(0,0, fct,id, fct.getFunctionText());

        //Erzeugung Startkante
        ForwardKante kante = new ForwardKante(evt.getId(), fct.getId(), evt, fct);
        kantenList.add(kante);
        list.add(startElement);
        list.add(kante);
        list.add(endElement);


        while((amountLoops + amountRhombus) > i)
        {
            //Auswählen der zufälligen Kante
            kantenIndex = rndKante(kantenList);

            if(i_rhombus > 0)
            {
                Random rndGate = new Random();
                Rhombus rhombus;
                if(rndGate.nextInt(3)==0)
                {
                    rhombus = new AndRhombus(kantenIndex, list, id, kantenList, new AND(id, 0), new AND(++id, 0));
                }
                else if(rndGate.nextInt(3)==1)
                {
                    rhombus = new OrRhombus(kantenIndex, list, id, kantenList, new OR(id,0), new OR(++id, 0));
                }
                else
                {
                    rhombus = new XorRhombus(kantenIndex, list, id, kantenList, new XOR(id, 0), new XOR(++id, 0));
                }
                list.add(rhombus);
                id++;
                i_rhombus--;
            }
            else if(i_loop > 0)
            {
                Loop loop = new Loop(kantenIndex, list, id, kantenList, new OR(++id, 0), new XOR(++id, 0));
                list.add(loop);
                i_loop--;
            }
            i++;
        }
        kantenList = checkGates(kantenList);
    }

    public Integer rndKante(List<Kante> kantenList)
    {
        Random random = new Random();
        if(kantenList.size()==1)
        {
            return 1;
        }
        return random.nextInt(kantenList.size())+1;
    }

    public List<Kante> checkGates(List<Kante> kantenList)
    {
        boolean check = true;
        //while(check == true)
        {
            for (int i = 0; i < kantenList.size(); i++) {
            //Wenn start und ende auf das gleiche Element zeigt
                if (((Kante) kantenList.get(i)).getEndID() == ((Kante) kantenList.get(i)).getStartID()) {
                    ((Kante) kantenList.get(i)).setEndID(((Kante) kantenList.get(i)).getEndID() + 1);
                }
                //if()
            }
        }
        return kantenList;
    }

    public List<Kante> getKantenList() {
        return kantenList;
    }

    public void setKantenList(List<Kante> kantenList) {
        this.kantenList = kantenList;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
