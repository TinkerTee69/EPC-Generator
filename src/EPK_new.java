import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EPK_new {

    List<Kante> kantenList = new ArrayList<>();
    List<Object> list = new ArrayList<>();
    Parameters params;

    public EPK_new(Parameters parameters) {
        setParams(parameters);
        params = getParams();
        Integer amountLoops = params.getLoops();
        Integer amountRhombus = params.getRhomben();
        int i = 0;
        int i_rhombus = amountRhombus;
        int i_loop = amountLoops;
        int kantenIndex;

        //Erzeugung zweier Startelemente
        Event evt = new Event("Start Event");
        Event evt2 = new Event("Prozess beendet");

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
                int rndGate = new Random().nextInt(3);
                Rhombus rhombus;
                //zufällige Auswahl der Gateart des Rhombuses
                if(rndGate==0)
                {
                    rhombus = new AndRhombus(kantenIndex,list, kantenList, new AND(), new AND());
                }
                else if(rndGate==1)
                {
                    rhombus = new OrRhombus(kantenIndex, list, kantenList, new OR(), new OR());
                }
                else
                {
                    rhombus = new XorRhombus(kantenIndex, list, kantenList, new XOR(), new XOR());
                }
                list.add(rhombus);

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
        checkElements();
    }

    public void checkElements () {
        //Vertrauen ist gut, paranoide alle-guten-Dinge-sind-3 Überprüfungen sind besser
        for(int i = 0; i <3; i++)
            checkElementsBefore();
            checkElementsAfter();
            checkXOOR();
            checkBeforeAndAfterGate();
    }

    //Elemente vor dem Startgate eines Rhombuses/Loops überprüfen und ggf. einfügen
    public void checkElementsBefore(){
        int i = 0;
        while(list.size() > i){
            //withoutChange ist das Flag um zu überprüfen, ob Änderungen vorgenommen wurden,
            // wenn dies der Fall ist, soll die Überprüfung so lange durchlaufen, bis syntaktische Korrektheit herrscht
            boolean withoutChange = true;
            if(list.get(i) instanceof RhombusOrLoop){
                //Überprüfen der Elemente vor dem Rhombus/Loop
                // & Überprüfen der Kante vor dem Element
                for(int j = 0; list.size() > j; j++) {
                    if (list.get(j) instanceof ForwardKante) {
                        //Wenn eine Kante das Element als Ende referenziert, wird das Startreferenzelement angeschaut
                        if (((ForwardKante) list.get(j)).getRefEnd().equals(((RhombusOrLoop) list.get(i)).getRefStart()) ){
                            //wenn davor ein Gate oder Event stattfindet, werden Elemente hinzugefügt
                            if (((ForwardKante) list.get(j)).getRefStart() instanceof Gate || ((ForwardKante) list.get(j)).getRefStart() instanceof Event) {
                                //wenn davor bereits Event und Function vorhanden sind, mache nichts, ansonsten addFunction
                                if(((ForwardKante) list.get(j)).getRefStart() instanceof Event) {
//                                    boolean checkFunctionBeforEvent = false;
//                                    for(int k = 0; list.size() > k; k++) {
//                                        if(list.get(k) instanceof ForwardKante && ((ForwardKante) list.get(k)).getRefEnd().equals(((ForwardKante) list.get(j)).getRefStart())){
//                                            if(((ForwardKante) list.get(k)).getRefStart() instanceof Function) {
//                                                checkFunctionBeforEvent = true;
//                                                break;
//                                            }
//                                        }
//                                    }
//                                    if (!checkFunctionBeforEvent) {
//                                        addFunctionBefore(i, j);
//                                        break;
//                                    }
                                }
                                else {
                                    //wenn das Element davor ein Gate ist, füge zufällig viele Elemente hinzu,
                                    // innerhalb der min/max Parameter
                                    Random rnd = new Random();
                                    int rndAmountElements;
                                    int rndStartElement = rnd.nextInt(2);

                                    //Wenn min == max Parameter ist, wird einfach min Parameter genommen
                                    if(params.getMaxElements() - params.getMinElements() == 0){
                                        rndAmountElements = params.getMinElements();
                                    }
                                    //Ansonsten zufällig viele innerhalb der Parameter
                                    else {
                                        rndAmountElements = rnd.nextInt(params.getMaxElements()- params.getMinElements())+params.getMinElements();
                                    }

                                    //Wenn es sich um die erste Einfügung handelt, muss firstAdd true sein,
                                    // damit beim ersten Einsetzen eine Kante zwischen Gate und Element erstellt wird
                                    boolean firstAdd = true;
                                    Object oldObject = null;


                                    //zufällige Auswahl mit welchem Elementtypen gestartet wird, danach im Wechsel
                                    for(int l = 0; rndAmountElements > l; l++){
                                        if((l+rndStartElement)%2==0){
                                            Function fct = new Function();
                                            addElementBeforeStart(fct, i, j, firstAdd, oldObject);
                                            oldObject = fct;
                                        }
                                        else{
                                            Event evt = new Event();
                                            addElementBeforeStart(evt,i,j, firstAdd, oldObject);
                                            oldObject = evt;
                                        }

                                        firstAdd=false;
                                    }
                                }
                                withoutChange = false;
                            }
                            break;
                        }
                    }
                }
            }
            i++;
            if(i==list.size() && !withoutChange)
            {
                i = 0;
            }
        }
        System.out.println();
    }

    //Überprüfung und ggf Einfügen von Elementen nach dem Startgate eines Rhombuses / Loops
    public void checkElementsAfter(){
        int i = 0;
        Parameters parameters = getParams();
        while(list.size() > i)
        {
            boolean withoutChange = true;
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
                                int rndStartElement = rnd.nextInt(2);
                                for(int l = 0; rndAmountElements > l; l++){
                                    if((l+rndStartElement)%2==0){
                                        Function fct = new Function();
                                        addElementBeforeEnd(fct, i, j, firstAdd, oldObject);
                                        oldObject = fct;

                                    }
                                    else{
                                        Event evt = new Event();
                                        addElementBeforeEnd(evt,i,j, firstAdd, oldObject);
                                        oldObject = evt;
                                    }
                                    firstAdd=false;
                                }
                                withoutChange = false;
                                }
                        }
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


    //Überprüfung ob Events vor (X)OR Gates stehen, wenn ja Funktion dazwischen einfügen
    public void checkXOOR(){
        int i = 0;
        Parameters parameters = getParams();
        while(list.size() > i) {
            boolean withoutChange = true;
            //Wenn die aktuelle ein (X)OR Gate als Ende referenziert und das vorherige Element ein Event ist
            if(list.get(i) instanceof ForwardKante
                    && (((ForwardKante) list.get(i)).getRefEnd() instanceof XOR
                        || ((ForwardKante) list.get(i)).getRefEnd() instanceof OR)
                    && ((ForwardKante) list.get(i)).getRefStart() instanceof Event
            ){
                //Wenn max Parameter noch nicht ausgescöpft, wird eine Funktion dazwischen eingefügt
                if(countElementsBetweenGates(i) < params.getMaxElements()) {
                    Function fct = new Function();
                    Kante kante = new ForwardKante(fct,((ForwardKante) list.get(i)).getRefEnd());
                    ((ForwardKante) list.get(i)).setRefEnd(fct);
                    add2list(fct,kante,list);
                    withoutChange = false;
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
                            withoutChange = false;
                            list.remove(i);
                            break;
                        }
                    }
                }
            }
            i++;
            if(i == list.size() && !withoutChange){
                i = 0;
            }
        }
    }

    //Überprüfung ob vor und nach einem Gate das gleiche Element ist, wenn ja, dann wird das nachfolgende geändert
    public void checkBeforeAndAfterGate(){
        //Flag zur Identifizierung, ob der max Parameter ausgeschöpft ist
        boolean maxElementsFlag = false;
        //Flag zur Identifizierung, ob hinter dem Start oder EndGate das Element verändert werden muss
        int startFlag = 0;
        //Da die Liste list hier wächst kann list.size() nicht verwendet werden, ansonsten Endlosloop
        int listSize = list.size();
        int i = 0;
        while(i < listSize){
            boolean withoutChange = true;
            // Wenn in der Kante als Endreferenz ein Gate ist, wird die Kante gesucht, bei der das Gate die Startrefernz ist
            if(list.get(i) instanceof ForwardKante
                    && ((ForwardKante) list.get(i)).getRefEnd() instanceof Gate){
                //Suche der Kante mit dem Gate als Startreferenz
                for(int j = 0; j < listSize; j++){
                    if(list.get(j) instanceof ForwardKante
                            //Überprüfung ob es sich um die Kante mit der Gate Refernz handelt
                            && ((ForwardKante) list.get(j)).getRefStart().equals(((ForwardKante) list.get(i)).getRefEnd())
                            //Überprüfung ob das Element vor und nach dem Gate die gleiche Elementklasse haben
                            && ((ForwardKante) list.get(j)).getRefEnd().getClass().equals(((ForwardKante) list.get(i)).getRefStart().getClass())){
                        //Überprüfung ob der Parameter für maximale Elemente erreicht ist
                        //Wenn nicht, wird ein Element hinzugefügt
                        if(countElementsBetweenGates(j) >= params.getMaxElements()){
                            maxElementsFlag = true;
                        }

                        //Wenn diese Kante gefunden wurde, wird überprüft, ob es sich um eine Dopplung von Events oder Funktionen handelt
                        //Wenn max Parameter erreicht -> Löschen
                        if(maxElementsFlag){
                            //Löschen des Elements for dem Gate
                            //Suchen der nachfolgenden Kante um diese mit dem Gate zu verbinden und die alte Kante & Element zu löschen
                            for(int k = 0; k < listSize; k++)
                            {
                                if(((ForwardKante) list.get(j)).getRefEnd().equals(((ForwardKante)list.get(k)).getRefStart())){
                                    ((ForwardKante) list.get(k)).setRefStart(((ForwardKante) list.get(j)).getRefStart());
                                    list.remove(((ForwardKante) list.get(j)).getRefStart());
                                    kantenList.remove(((ForwardKante) list.get(j)));
                                    break;
                                }
                            }
                            withoutChange = false;
                        }
                        //Wenn jedoch noch Elemente hinzugefügt werden dürfen, wird dies getan
                        else {
                            //startFlag: bei 1 muss nach dem Start Rhombus/Loop das Element angehangen werden
                            //bei 2 nach dem Ende des Rhombus/Loops
                            startFlag = 0;
                            for (int l = 0; l < listSize; l++) {
                                if(list.get(l) instanceof RhombusOrLoop ){
                                    if((((ForwardKante) list.get(i)).getRefEnd().equals(((RhombusOrLoop) list.get(l)).getRefStart()))){
                                        startFlag = 1;
                                    }
                                    else if(((ForwardKante) list.get(i)).getRefEnd().equals(((RhombusOrLoop) list.get(l)).getRefEnd())) {
                                        startFlag = 2;
                                    }
                                    if(startFlag != 0) {
                                        //wenn es sich um eine Dopplung von Events handelt, wir eine Funktion eingefügt
                                        if (((ForwardKante) list.get(i)).getRefStart() instanceof Event) {
                                            addElementAfter(new Function(), l, j, startFlag);
                                        // wenn es sich um eine Dopplung von Funktionen handelt, wir ein Event eingefügt
                                        } else {
                                            addElementAfter(new Event(), l, j, startFlag);
                                        }
                                        withoutChange = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            i++;
            //Überprüfung ob etwas geändert wurde und daher das EPK nochmal überprüft werden muss
            if(i==listSize && !withoutChange)
            {
                i = 0;
                listSize = list.size();
            }
        }
    }

    //Zählen von Elementen zwischen Gates zur Ermittlung, ob die min/max Parameter eingehalten werden
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
                    else if(j == list.size()){
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
        Event evt = new Event();
        Kante kante = new ForwardKante(evt, fct);
        ((Kante) list.get(kantenIndex)).setRefEnd(evt);
        add2list(evt,kante,list);
        return evt;
    }

    public void addElementAfter(Object obj, int elementIndex, int kantenIndex, int startFlag){
        Kante kante;
        if(startFlag == 1) {
             kante = new ForwardKante(((RhombusOrLoop) list.get(elementIndex)).getRefStart(), obj);
        }
        else {
            kante = new ForwardKante(((RhombusOrLoop) list.get(elementIndex)).getRefEnd(), obj);
        }
        ((Kante) list.get(kantenIndex)).setRefStart(obj);
        add2list(obj, kante, list);
    }

    public Function addFunctionBefore(int elementIndex, int kantenIndex)
    {
        Function fct = new Function();
        Kante kante = new ForwardKante(fct, ((RhombusOrLoop) list.get(elementIndex)).getRefStart());


        ((Kante) list.get(kantenIndex)).setRefEnd(fct);
        add2list(fct, kante, list);
        return fct;
    }

    //Methode zum Einfügen von Elementen nach Gates zur Verhinderung von Dopplungen vor und hinter einem Gate
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

    //Einfügen von Elementen zwischen Start und Endgate
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

    public Event addEventAfter(int kantenIndex, Function fct)
    {
        Event evt = new Event();
        Kante kante = new ForwardKante(evt, fct);
        ((Kante) list.get(kantenIndex)).setRefEnd(evt);
        add2list(evt, kante, list);
        return evt;
    }

    //Auswahl einer zufälligen Kante zum Einfügen eines Rhombuses/Loops
    public Integer rndKante()
    {
        Random random = new Random();
        if(kantenList.size()==1)
        {
            return 1;
        }
        return random.nextInt(kantenList.size())+1;
    }

    //Methode zum aktualisieren der Listen
    public void add2list(Object obj, Kante kante, List<Object> list){
        list.add(obj);
        list.add(kante);
        setList(list);
        kantenList.add(kante);
        setKantenList(kantenList);
    }


    /////////////////GETTER & SETTER //////////////////////
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
