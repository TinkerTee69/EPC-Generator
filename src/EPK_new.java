import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EPK_new {

    List<Kante> kantenList = new ArrayList<>();
    List<Object> list = new ArrayList<>();
    Object params;

    public EPK_new(Parameters parameters) {
        setParams(parameters);
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
            kantenIndex = rndKante();

            if(i_rhombus > 0)
            {
                Random rndGate = new Random();
                Rhombus rhombus;
                if(rndGate.nextInt(3)==0)
                {
                    rhombus = new AndRhombus(kantenIndex,list, kantenList, new AND(), new AND(), parameters);
                }
                else if(rndGate.nextInt(3)==1)
                {
                    rhombus = new OrRhombus(kantenIndex, list, kantenList, new OR(), new OR(), parameters);
                }
                else
                {
                    rhombus = new XorRhombus(kantenIndex, list, kantenList, new XOR(), new XOR(), parameters);
                }
                list.add(rhombus);
                id++;
                i_rhombus--;
            }
            else if(i_loop > 0)
            {
                Loop loop = new Loop(kantenIndex,list, kantenList, new OR(), new XOR(), parameters);
                list.add(loop);
                i_loop--;
            }
            i++;
        }
        for(int o = 0; o < 100; o++)
        {
            checkElements();
        }
    }

    public void checkElements () {
        checkElementsBefore();
        checkElementsAfter();
    }

    public void checkElementsBefore(){
        int i = 0;
        while(list.size() > i)
        {
            boolean withoutChange = true;
            //if(list.get(i) instanceof XOORhombus || list.get(i) instanceof  Loop)
            if(list.get(i) instanceof RhombusOrLoop)
            {
                //Überprüfen der Elemente vor dem XOOR Rhombus/Loop
                //Überprüfen der Kante vor dem Element
                for(int j = 0; list.size() > j; j++) {
                    if (list.get(j) instanceof Kante) {
                        //Wenn eine Kante das Element als Ende referenziert, wird das Startreferenzelement angeschaut
                        if (((Kante) list.get(j)).getRefEnd().equals(((RhombusOrLoop) list.get(i)).getRefStart()) ){
                            //wenn davor ein Gate oder Event stattfindet, werden Elemente hinzugefügt
                            if (((Kante) list.get(j)).getRefStart() instanceof Gate || ((Kante) list.get(j)).getRefStart() instanceof Event) {
                                //wenn davor bereits Event und Function vorhanden sind, mache nichts, ansonsten addFunction
                                if(((Kante) list.get(j)).getRefStart() instanceof Event) {
                                    boolean checkFunctionBeforEvent = false;
                                    for(int k = 0; list.size() > k; k++) {
                                        if(list.get(k) instanceof Kante && ((Kante) list.get(k)).getRefEnd().equals(((Kante) list.get(j)).getRefStart())){
                                            if(((Kante) list.get(k)).getRefStart() instanceof Function) {
                                                checkFunctionBeforEvent = true;
                                                //break;
                                            }
                                        }
                                    }
                                    if (!checkFunctionBeforEvent) {
                                        addFunctionBefore(i, j);
                                        //break;
                                    }
                                }
                                else {
                                    //wenn das Element davor ein Gate ist
                                    Function fct = addFunctionBefore(i, j);
                                    addEventBefore(j, fct);
                                }
                                withoutChange = false;
                            }
                            //break;
                        }
                    }
                }
            }
            i++;
            if(!withoutChange)
            {
                i = 0;
            }
        }
        System.out.println();
    }

    public void checkElementsAfter(){
        int i = 0;
        while(list.size() > i)
        {
            boolean withoutChange = true;
            //if(list.get(i) instanceof XOORhombus || list.get(i) instanceof  Loop)
            if(list.get(i) instanceof RhombusOrLoop)
            {
                //Überprüfen der Elemente vor dem XOOR Rhombus/Loop
                //Überprüfen der Kante vor dem Element
                for(int j = 0; list.size() > j; j++) {
                    if (list.get(j) instanceof Kante) {
                        //Wenn eine Kante das Element als Start referenziert, wird das Endreferenzelement angeschaut
                        if (((Kante) list.get(j)).getRefEnd().equals(((RhombusOrLoop) list.get(i)).getRefEnd()) ){
                            System.out.println();
                            //wenn danach ein Gate ist, werden Elemente hinzugefügt
                            if (((Kante) list.get(j)).getRefStart() instanceof Gate) {
                                //wenn das Element davor ein Gate ist
                                Function fct = addFunctionAfter(i, j);
                                addEventAfter(j, fct);
                                withoutChange = false;
                                }
                        }
                            //break;
                    }
                }
            }
            i++;
            if(!withoutChange)
            {
                i = 0;
            }
        }
        System.out.println();
    }

    public Event addEventBefore(int kantenIndex, Function fct)
    {
        Event evt = new Event(0, 0, "Event Text");
        Kante kante = new ForwardKante(evt, fct);
        ((Kante) list.get(kantenIndex)).setRefEnd(evt);
        add2list(evt,kante,list);
        return evt;
    }

    public Function addFunctionBefore(int elementIndex, int kantenIndex)
    {
        Function fct = new Function(0, 0, "Function Text");
        Kante kante = new ForwardKante(fct, ((RhombusOrLoop) list.get(elementIndex)).getRefStart());
        ((Kante) list.get(kantenIndex)).setRefEnd(fct);
        add2list(fct, kante, list);
        return fct;
    }

    public Event addEventAfter(int kantenIndex, Function fct)
    {
        Event evt = new Event(0, 0, "Event Text");
        Kante kante = new ForwardKante(evt, fct);
        ((Kante) list.get(kantenIndex)).setRefEnd(evt);
        add2list(evt, kante, list);
        return evt;
    }

    public Function addFunctionAfter(int elementIndex, int kantenIndex)
    {
        Function fct = new Function(0, 0, "Function Text");
        //Kante zwischen neuer Funktion und alten Endelement
        Kante kante = new ForwardKante(fct, ((RhombusOrLoop) list.get(elementIndex)).getRefEnd());
        //vorhandene Kante anpassen an neues Startelement fct
        ((Kante) list.get(kantenIndex)).setRefEnd(fct);
        add2list(fct, kante, list);

        return fct;
    }

    public Integer rndKante()
    {
        Random random = new Random();
        if(kantenList.size()==1)
        {
            return 1;
        }
        return random.nextInt(kantenList.size())+1;
    }

    public void add2list(Object obj, Kante kante, List<Object> list){
        list.add(obj);
        list.add(kante);
        setList(list);
        kantenList.add(kante);
        setKantenList(kantenList);
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public List<Kante> getKantenList() {
        return kantenList;
    }

    public void setKantenList(List<Kante> kantenList) {
        this.kantenList = kantenList;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }
}
