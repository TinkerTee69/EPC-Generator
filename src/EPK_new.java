import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EPK_new {

    List<Kante> kantenList = new ArrayList<>();
    List<Object> list = new ArrayList<>();

    public EPK_new(GeneratorEPK generatorEPK) {
        //List<Object> list = new ArrayList<>();
        Integer id = 0;
        int kantenIndex;
        Random rndLoopRhombus = new Random();
        Event evt = new Event(++id, "Event Text");

        EPK_Element startElement = new EPK_Element(0,0, evt, id, evt.getEventText());

        Function fct = new Function(++id, "Function Text");

        //functionList.addElement(fct);
        //eventList.addElement(evt);

        EPK_Element endElement = new EPK_Element(0,0, fct,id, fct.getFunctionText());


        Parameters parameters = new Parameters();
        Integer amountLoops = generatorEPK.getAmountLoops();
        Integer amountRhombus = generatorEPK.getAmountRhomben();

        ForwardKante kante = new ForwardKante(evt.getId(), fct.getId(), evt, fct);
        kantenList.add(kante);
        list.add(startElement);
        list.add(kante);
        list.add(endElement);
        int i = 0;
        int i_rhombus = amountRhombus;
        int i_loop = amountLoops;
        while((amountLoops + amountRhombus) > i)
        {
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
        System.out.println("KantenListe: " + kantenList);
        System.out.println("Liste: " + list);

    }

    public Integer rndKante(List<Kante> kantenList)
    {
        Random random = new Random();
        return random.nextInt(kantenList.size())+1;
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
