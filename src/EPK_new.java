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


        ForwardKante kante = new ForwardKante(evt.getId(), fct.getId());
        kantenList.add(kante);

        Parameters parameters = new Parameters();
        Integer amountLoops = generatorEPK.getAmountLoops();
        Integer amountRhombus = generatorEPK.getAmountRhomben();

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
                Object rhombus;
                if(rndGate.nextInt(3)%3==0)
                {
                    rhombus = new AndRhombus(kantenIndex, list, id, kantenList);
                }
                else if(rndGate.nextInt(3)%3==1)
                {
                    rhombus = new OrRhombus(kantenIndex, list, id, kantenList);
                }
                else
                {
                    rhombus = new XorRhombus(kantenIndex, list, id, kantenList);
                }
                list.add(rhombus);
                i_rhombus--;
            }
            else if(i_loop > 0)
            {
                Loop loop = new Loop(kantenIndex, list, id, kantenList);
                list.add(loop);
                i_loop--;
            }
            else
            {
//                break;
            }
            i++;
        }
    System.out.println("Liste: " + list);
    }


    public Integer rndKante(List<Kante> kantenList)
    {
        Random random = new Random();
        return random.nextInt(kantenList.size())+1;
    }
}
