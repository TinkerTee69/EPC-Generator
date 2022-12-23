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
        Event evt = new Event(0,0,"Event Text");
        Function fct = new Function(0, 0, "Function Text");

        //Erzeugung Startkante
        ForwardKante kante = new ForwardKante(evt, fct);
        kantenList.add(kante);
        list.add(evt);
        list.add(kante);
        list.add(fct);


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
                    rhombus = new AndRhombus(kantenIndex,list, kantenList, new AND(), new AND());
                }
                else if(rndGate.nextInt(3)==1)
                {
                    rhombus = new OrRhombus(kantenIndex, list, kantenList, new OR(), new OR());
                }
                else
                {
                    rhombus = new XorRhombus(kantenIndex, list, kantenList, new XOR(), new XOR());
                }
                list.add(rhombus);
                id++;
                i_rhombus--;
            }
            else if(i_loop > 0)
            {
                Loop loop = new Loop(kantenIndex,list, kantenList, new OR(), new XOR());
                list.add(loop);
                i_loop--;
            }
            i++;
        }
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


    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
