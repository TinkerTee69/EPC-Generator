import javax.sound.midi.SysexMessage;
import javax.xml.stream.events.EndElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EPK_new {

    List<Kante> kantenList = new ArrayList<>();

    public EPK_new(GeneratorEPK generatorEPK) {
        List<Object> list = new ArrayList<>();
        Integer id = 0;
        int kantenIndex;
        Random rndLoopRhombus = new Random();
        Event evt = new Event(++id, "Event Text");

        EPK_Element startElement = new EPK_Element(0,0, evt, id);

        Function fct = new Function(++id, "Function Text");

        //functionList.addElement(fct);
        //eventList.addElement(evt);

        EPK_Element endElement = new EPK_Element(0,0, fct,id);


        Kante kante = new Kante(evt.getId(), fct.getId(), 1);
        kantenList.add(kante);

        Parameters parameters = new Parameters();
        Integer amountLoops = generatorEPK.getAmountLoops();
        Integer amountRhombus = generatorEPK.getAmountRhomben();

        list.add(startElement);
        list.add(kante);
        list.add(endElement);
        int i = 0;
        while((amountLoops + amountRhombus) > i)
        {
            List<Object> tmp_list = list;
            //Rhombus
            if(rndLoopRhombus.nextInt() % 2 == 0)
            {
                for(int j = 0; j < list.size(); j++)
                {
                    kantenIndex = rndKante(kantenList);
                    if(list.get(j) instanceof Kante && (kantenIndex == ((Kante) list.get(j)).getKantenID()))
                    {
                        Random rndGate = new Random();
                        Object gate, gate2 = new Object();
                        if(rndGate.nextInt(3)%3==0)
                        {
                            gate = new AND(++id,0);
                            gate2 = new AND(id+1, 0);
                        }
                        else if(rndGate.nextInt(3)%3==1)
                        {
                            gate = new OR(++id,0);
                            gate2 = new OR(id+1,0);
                        }
                        else
                        {
                            gate = new XOR(++id,0);
                            gate2 = new XOR(id+1,0);
                        }
                        list.add(id, gate);

                        //kantenList.remove()
                        ((Kante) list.get(j)).setEndID(id);
                        //die 2 neuen Kanten
                        Kante kante1 = new Kante(id,id+1,kante.kantenID());
                        Kante kante2 = new Kante(id,id+1,kante.kantenID());

                        list.add(kante1);
                        list.add(kante2);
                        list.add(gate2);

                        // Kante vom letzten hinzugefügten Element zum nachfolgendem Element
                        Kante kante3 = new Kante(++id, id-2,kante.kantenID());
                        kantenList.add(kante1);
                        kantenList.add(kante2);
                        kantenList.add(kante3);
                        list.add(kante3);

                        i++;
                        break;
                    }
                }
            }
        }
        System.out.println("bla");
    }

    public Integer rndKante(List<Kante> kantenList)
    {

        Random random = new Random();
        return random.nextInt(kantenList.size())+1;
    }
}
