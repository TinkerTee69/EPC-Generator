import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EPK_new {

    List<Kante> kantenList = new ArrayList<>();
    List<Object> list = new ArrayList<>();
    Parameters params;

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
        Event evt = new Event(0,0,"Start Event");
        Event evt2 = new Event(0, 0, "Last Event");

        //Erzeugung Startkante
        ForwardKante kante = new ForwardKante(evt, evt2);
        kantenList.add(kante);
        list.add(evt);
        list.add(kante);
        list.add(evt2);


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
         //   checkElements();
        }
        checkElements();
    }

    public void checkElements () {
        checkElementsBefore();
        checkElementsAfter();
        //checkXOOR();
        checkBeforeAndAfterGate();
    }

    public void checkElementsBefore(){
        int i = 0;
//        Parameters parameters = getParams();
        while(list.size() > i)
        {
            boolean withoutChange = true;
            //if(list.get(i) instanceof XOORhombus || list.get(i) instanceof  Loop)
            if(list.get(i) instanceof RhombusOrLoop)
            {
                //Überprüfen der Elemente vor dem XOOR Rhombus/Loop
                //Überprüfen der Kante vor dem Element
                for(int j = 0; list.size() > j; j++) {
                    if (list.get(j) instanceof ForwardKante) {
                        //Wenn eine Kante das Element als Ende referenziert, wird das Startreferenzelement angeschaut
                        if (((ForwardKante) list.get(j)).getRefEnd().equals(((RhombusOrLoop) list.get(i)).getRefStart()) ){
                            //wenn davor ein Gate oder Event stattfindet, werden Elemente hinzugefügt
                            if (((ForwardKante) list.get(j)).getRefStart() instanceof Gate || ((ForwardKante) list.get(j)).getRefStart() instanceof Event) {
                                //wenn davor bereits Event und Function vorhanden sind, mache nichts, ansonsten addFunction
                                if(((ForwardKante) list.get(j)).getRefStart() instanceof Event) {
                                    boolean checkFunctionBeforEvent = false;
                                    for(int k = 0; list.size() > k; k++) {
                                        if(list.get(k) instanceof ForwardKante && ((ForwardKante) list.get(k)).getRefEnd().equals(((ForwardKante) list.get(j)).getRefStart())){
                                            if(((ForwardKante) list.get(k)).getRefStart() instanceof Function) {
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
                                    Random rnd = new Random();
                                    int rndAmountElements;
                                    if(params.getMaxElements() - params.getMinElements() == 0)
                                    {
                                        rndAmountElements = params.getMinElements();
                                    }
                                    else {
                                        rndAmountElements = rnd.nextInt(params.getMaxElements()- params.getMinElements())+params.getMinElements();
                                    }
                                    boolean firstAdd = true;
                                    Object oldObject = null;
                                    for(int l = 0; rndAmountElements > l; l++){
                                        if(l%2==0){
                                            Function fct = new Function("Function Text");
                                            addElementBeforeStart(fct, i, j, firstAdd, oldObject);
                                            oldObject = fct;

                                        }
                                        else{
                                            Event evt = new Event("Event Text");
                                            addElementBeforeStart(evt,i,j, firstAdd, oldObject);
                                            oldObject = evt;
                                        }
                                        firstAdd=false;
                                    }

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
        Parameters parameters = getParams();
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
                        if (((Kante) list.get(j)).getRefEnd().equals(((RhombusOrLoop) list.get(i)).getRefEnd()) ){
                            //wenn dieses StartreferenzElement ein Gate ist, werden Elemente hinzugefügt
                            if (((Kante) list.get(j)).getRefStart() instanceof Gate) {
                                Random rnd = new Random();
                                int rndAmountElements;
                                //Erzeugung einer zufälligen Anzahl an Elementen die hinzugefügt werden sollen
                                if(parameters.getMaxElements() - parameters.getMinElements() == 0)
                                {
                                    rndAmountElements = parameters.getMinElements();
                                }
                                else {
                                    rndAmountElements = rnd.nextInt(getParams().getMaxElements()- parameters.getMinElements())+parameters.getMinElements();
                                }
                                boolean firstAdd = true;
                                Object oldObject = null;
                                for(int l = 0; rndAmountElements > l; l++){
                                    if(l%2==0){
                                        Function fct = new Function("Function Text");
                                        addElementBeforeEnd(fct, i, j, firstAdd, oldObject);
                                        oldObject = fct;

                                    }
                                    else{
                                        Event evt = new Event("Event Text");
                                        addElementBeforeEnd(evt,i,j, firstAdd, oldObject);
                                        oldObject = evt;
                                    }
                                    firstAdd=false;
                                }

//                                Function fct = addFunctionAfter(i, j);
//                                addEventAfter(j, fct);
                                withoutChange = false;
                                }
                        }
                            //break;
                    }
                }
            }
            i++;
            //Wenn die Überprüfung einmal ohne Fehlererkennung durchgeht, wird die Schlange verlassen
            //Anonsten wird i = 0 gesetzt
            if(!withoutChange)
            {
                i = 0;
            }
        }
        System.out.println();
    }


    public void checkXOOR(){
        int i = 0;
        Parameters parameters = getParams();
        while(list.size() > i) {
            boolean withoutChange = true;
            if(list.get(i) instanceof ForwardKante
                    && (((ForwardKante) list.get(i)).getRefEnd() instanceof XOR
                        || ((ForwardKante) list.get(i)).getRefEnd() instanceof OR)
                    && ((ForwardKante) list.get(i)).getRefStart() instanceof Event){
                //Wenn max Parameter noch nicht ausgescöpft, wird eine Funktion hinzugefügt
                if(countElementsBetweenGates(i) < params.getMaxElements()) {
                    Function fct = new Function(0,0,"fct Text");
                    //addElementBeforeEnd(new Function(0,0,"fct Text"),);
                    Kante kante = new ForwardKante(fct,((ForwardKante) list.get(i)).getRefEnd());
                    ((ForwardKante) list.get(i)).setRefEnd(fct);
                    add2list(fct,kante,list);
                }
                //Ansonsten wird das Event gelöscht
                else
                {
                    for(int k = 0;k < list.size();k++) {
                        if (list.get(k) instanceof ForwardKante
                                && ((ForwardKante) list.get(k)).getRefEnd().equals(((ForwardKante) list.get(i)).getRefStart())) {
                            ((ForwardKante) list.get(k)).setRefEnd(((ForwardKante) list.get(i)).getRefEnd());
                            for(int l = 0; l < list.size(); l++)
                            {
                                if(((ForwardKante) list.get(i)).getRefStart().equals(list.get(l))){
                                    list.remove(l);
                                }
                            }
                            list.remove(i);
                            break;
                        }
                    }
                }
//                //Überprüfen der Elemente vor dem XOOR Rhombus/Loop
//                //Überprüfen der Kante vor dem Element
//                for (int j = 0; list.size() > j; j++) {
//                    if (list.get(j) instanceof Kante) {
//                        //Wenn eine Kante das Element als Ende referenziert, wird das Startreferenzelement angeschaut
//                        if (((Kante) list.get(j)).getRefEnd().equals(((Kante) list.get(i)).getRefStart()) ){
//                            //wenn das Kantenelement ein Event ist, wird eine Funktion hinzugefügt wenn max nicht erreicht wurde, anonsten wird das Event gelöscht
//                            if (((Kante) list.get(j)).getRefStart() instanceof Event) {
//                                //Aufruf zählen der Elemente zwischen den Gates
//                                if(countElementsBetweenGates(i, j) >= params.getMaxElements()){
//                                    for(int k = 0;k < list.size();k++) {
//                                        if (list.get(k) instanceof ForwardKante
//                                                && ((ForwardKante) list.get(k)).getRefEnd().equals(((ForwardKante) list.get(j)).getRefStart())) {
//                                            ((ForwardKante) list.get(k)).setRefEnd(((ForwardKante) list.get(j)).getRefEnd());
//                                            break;
//                                        }
//                                    }
//                                    //Löschen des Events
//                                    list.remove(i);
//                                    list.remove(j);
//                                }
//                                else{
//                                    //hinzufügen einer Funktion zwischen Event und XOOR Gate
//                                    addFunctionAfter(i,j);
//                                    for(int l = 0; l < list.size();l++){
//                                        if(list.get(l) instanceof Kante){
//                                            if(((Kante)list.get(l)).getRefStart().equals(((Kante)list.get(j)).getRefEnd())){
//                                                if(((Kante)list.get(j)).getRefEnd() instanceof Event)
//                                                {
//                                                    addFunctionBefore(i,l);
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }

            }
            i++;
        }
    }

    public void checkBeforeAndAfterGate(){
        int i = 0;
        boolean maxElementsFlag = false;
        Object obj = new Object();
        int listSize = list.size();
        while(i < listSize){
            // Wenn in der Kante als Endreferenz ein Gate ist, wird die Kante gesucht, bei der das Gate die Startrefernz ist
            if(list.get(i) instanceof ForwardKante
                    && ((ForwardKante) list.get(i)).getRefEnd() instanceof Gate){
                for(int j = 0; j < listSize; j++){
                    //Suche der Kante mit dem Gate als Startreferenz
                    if(list.get(j) instanceof ForwardKante
                            //Überprüfung ob es sich um die Kante mit der Gate Refernz handelt
                            && ((ForwardKante) list.get(j)).getRefStart().equals(((ForwardKante) list.get(i)).getRefEnd())
                            //Überprüfung ob das Element vor und nach dem Gate die gleiche Elementklasse haben
                            && ((ForwardKante) list.get(j)).getRefEnd().getClass().equals(((ForwardKante) list.get(i)).getRefStart().getClass())){
                        //Überprüfung ob der Parameter für maximale Elemente erreicht ist
                        //Wenn nicht, wird ein Element hinzugefügt
                        if(countElementsBetweenGates(i) >= params.getMaxElements()){
                            maxElementsFlag = true;
                        }
                        //((ForwardKante) list.get(j)).getRefStart().getClass().equals(((ForwardKante) list.get(i)).getRefStart())){

                        //Wenn diese Kante gefunden wurde, wird überprüft ob es sich um eine Event oder Function Dopplung handelt
                        if(true){
                            if(maxElementsFlag){
                                //Löschen des Elements for dem Gate
                                //Suchen der vorherigen Kante um diese mit dem Gate zu verbinden und die alte Kante & Element zu löschen
                                for(int k = 0; k < listSize; k++)
                                {
                                    if(((ForwardKante) list.get(i)).getRefStart().equals(list.get(k))){
                                        ((ForwardKante) list.get(k)).setRefEnd(((ForwardKante) list.get(i)).getRefStart());
                                        list.remove(((ForwardKante) list.get(i)).getRefStart());
                                        kantenList.remove(((ForwardKante) list.get(i)));
                                    }
                                }

                            }
                            //Wenn jedoch noch Elemente hinzugefügt werden dürfen, wird dies getan
                            else {
                                for (int l = 0; l < listSize; l++) {
                                    if(list.get(l) instanceof RhombusOrLoop
                                            //Herausfinden der ElementID des Rhombus/Loops
                                            && (((ForwardKante) list.get(i)).getRefEnd().equals(((RhombusOrLoop) list.get(l)).getRefStart()))){
                                            //|| ((ForwardKante) list.get(i)).getRefEnd().equals(((RhombusOrLoop) list.get(l)).getRefEnd()))){
                                        if (((ForwardKante) list.get(i)).getRefStart() instanceof Event) {
                                            addElementAfter(new Function("!!!!FUNCTION!"), l, j);
                                        } else {
                                            addElementAfter(new Event("!!!!EVENT!"), l, j);
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
            i++;
        }
    }

    public int countElementsBetweenGates(int kantenIndex){
        boolean gateFlag = false;
        int i = 0;
        int count = 0;
        //Solange es sich nicht um ein Gate handelt, zähle die Elemente zum "Start" hin (also von Endelement zu Start)
        while(!gateFlag){
            if(((Kante)list.get(kantenIndex)).getRefStart() instanceof Gate
                    ||((Kante)list.get(kantenIndex)).getRefStart().equals(list.get(0))
                    ||list.get(kantenIndex) instanceof backwardKante)
            {
                gateFlag = true;
            }
            else
            {
                for(int j = 0;j < list.size();j++){
                    if(list.get(j) instanceof ForwardKante
                            && ((ForwardKante) list.get(j)).getRefEnd().equals(((ForwardKante) list.get(kantenIndex)).getRefStart()) ){
                        kantenIndex = j;
                        count++;
                        break;
                    }
                    //Wenn kein Element mehr davor gefunden wird, beende die Suche
                    else if(j == list.size()-1){
                        gateFlag = true;
                    }
                }
            }
            i++;
        }
        return count;
    }


    public Event addEventBefore(int kantenIndex, Function fct)
    {
        Event evt = new Event(0, 0, "Event Text");
        Kante kante = new ForwardKante(evt, fct);
        ((Kante) list.get(kantenIndex)).setRefEnd(evt);
        add2list(evt,kante,list);
        return evt;
    }

    public void addElementAfter(Object obj, int elementIndex, int kantenIndex){
        Kante kante = new ForwardKante(((RhombusOrLoop) list.get(elementIndex)).getRefEnd(), obj);

        ((Kante) list.get(kantenIndex)).setRefStart(obj);
        add2list(obj, kante, list);
    }

    public Function addFunctionBefore(int elementIndex, int kantenIndex)
    {
        Function fct = new Function(0, 0, "Function Text");
        Kante kante = new ForwardKante(fct, ((RhombusOrLoop) list.get(elementIndex)).getRefStart());


        ((Kante) list.get(kantenIndex)).setRefEnd(fct);
        add2list(fct, kante, list);
        return fct;
    }
    public Object addElementBeforeStart(Object obj, int elementIndex, int kantenIndex, boolean firstAdd, Object oldObject)
    {
        Kante kante;
        if(firstAdd) {
            //Kante zwischen neuer Funktion und alten Endelement
            kante = new ForwardKante(obj, ((RhombusOrLoop) list.get(elementIndex)).getRefStart());
        }
        else{
            kante = new ForwardKante(obj, oldObject);
        }
        //vorhandene Kante anpassen an neues Startelement obj
        ((Kante) list.get(kantenIndex)).setRefEnd(obj);
        add2list(obj, kante, list);
        return obj;
    }


    public Object addElementBeforeEnd(Object obj, int elementIndex, int kantenIndex, boolean firstAdd, Object oldObject)
    {
        Kante kante;
        //Kante zwischen neuer Funktion und alten Endelement
        if(firstAdd) {
            kante = new ForwardKante(obj, ((RhombusOrLoop) list.get(elementIndex)).getRefEnd());
        }
        else{
            kante = new ForwardKante(obj, oldObject);
        }
        //vorhandene Kante anpassen an neues Startelement fct
        ((Kante) list.get(kantenIndex)).setRefEnd(obj);
        add2list(obj, kante, list);

        return obj;
    }
//    public Function addFunctionAfter(int kantenIndex)
//    {
//        Function fct = new Function(0, 0, "Function Text");
//        //Kante zwischen neuer Funktion und alten Endelement
//        Kante kante = new ForwardKante(fct, ((RhombusOrLoop) list.get(elementIndex)).getRefEnd());
//        //vorhandene Kante anpassen an neues Startelement fct
//        ((Kante) list.get(kantenIndex)).setRefEnd(fct);
//        add2list(fct, kante, list);
//
//        return fct;
//    }


    public Event addEventAfter(int kantenIndex, Function fct)
    {
        Event evt = new Event(0, 0, "Event Text");
        Kante kante = new ForwardKante(evt, fct);
        ((Kante) list.get(kantenIndex)).setRefEnd(evt);
        add2list(evt, kante, list);
        return evt;
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

    public Parameters getParams() {
        return params;
    }

    public void setParams(Parameters params) {
        this.params = params;
    }
}
