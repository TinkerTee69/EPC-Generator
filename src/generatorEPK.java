import java.util.*;
public class generatorEPK {

    public void setAmountGates(Integer amountGates) {
        this.amountGates = amountGates;
    }

    private Integer amountGates;

    public void setAmountEvents(Integer amountEvents) {
        this.amountEvents = amountEvents;
    }

    public Integer getAmountFunctions() {
        return amountFunctions;
    }

    public void setAmountFunctions(Integer amountFunctions) {
        this.amountFunctions = amountFunctions;
    }

    private Integer amountEvents;
    private Integer amountFunctions;

    public List<String> getTypeGate() {
        return typeGate;
    }

    private final List<String> typeGate = new ArrayList<>();
    private Integer amountAND = 0;
    private Integer amountOR = 0;
    private Integer amountXOR = 0;

    private final List<Integer> position = new ArrayList<>();

    List<Object> gates = new ArrayList<>();
    private final gateList gate = new gateList(gates);
    List<Object> func = new ArrayList<>();
    private final functionList functions = new functionList(func);
    List<Object> evt = new ArrayList<>();
    private final eventList evtList = new eventList(evt);


    public void calcAmountGates(int difficulty, int knotGrade, int length){
        amountGates = Math.round((float)(difficulty + knotGrade + length)/3);
        if(knotGrade != length){
            amountGates = (int)Math.floor((float)amountGates * (float)(knotGrade/length));
        }

        if(length == 2){
            amountGates = (int)Math.ceil(amountGates * 1.51);
        }

        if(length == 3){
            amountGates = (int)Math.ceil(amountGates * 2);
        }

        if(amountGates == 0){
            amountGates++;
        }
        System.out.println("Anzahl Gates: " + amountGates);
    }

    public void calcAmountEvents(){
        //amountEvents = Math.round((float)(difficulty + knotGrade + length))*2;

        System.out.println("Anzahl Events: " + amountEvents);

        for(int i = 0; i < amountEvents; i++)
        {
            Event evt = new Event(i, "Event Nr. " + i);
            eventList.addElement(evt);
        }
    }

    public void calcAmountFunctions() {
        //amountFunctions = amountEvents -1;
        System.out.println("Anzahl Functions: " + amountFunctions);

        for(int i = 0; i < amountFunctions; i++)
        {
            Function fct = new Function(i, "hier könnte ihre Werbung stehen " + i);
            functionList.addElement(fct);
        }
    }

    public void randomizeTypeGate() {
        int i = 0;
        int difficulty = 3;
        while(i < amountGates) {
            i++;
            if (difficulty == 1) {
                if(amountAND >= ((float) (1.5 * amountOR + 1))) {
                    typeGate.add("OR");
                    amountOR++;
                    continue;
                }
                else{
                    typeGate.add("AND");
                    amountAND++;
                    continue;
                }
            }
            if (difficulty == 2) {
                if (amountOR >= (float) (1.3 * (amountXOR + 1))) {
                    typeGate.add("XOR");
                    amountXOR++;
                    continue;
                }
                if ((amountAND >= (float) (1.5 * amountOR))) {
                    typeGate.add("OR");
                    amountOR++;
                    continue;
                } else {
                    typeGate.add("AND");
                    amountAND++;
                    continue;
                }
            }
            if (difficulty == 3) {
                if (amountAND >= (float) (1.3 * amountOR + 1)) {
                    typeGate.add("OR");
                    amountOR++;
                    continue;
                }
                if (amountOR >= (float) (amountXOR + 1)) {
                    typeGate.add("XOR");
                    amountXOR++;
                }
                else {
                    typeGate.add("AND");
                    amountAND++;
                }
            }
        }
        Collections.shuffle(typeGate);
        for(int k = 0; k < typeGate.size();k++)
        {
            if(Objects.equals(typeGate.get(k), "AND"))
            {
                AND and = new AND(k);
                gate.addElement(and);
            }
            else if(Objects.equals(typeGate.get(k), "OR"))
            {
                OR or = new OR(k);
                gate.addElement(or);
            }
            else
            {
                XOR xor = new XOR(k);
                gate.addElement(xor);
            }
        }
        System.out.println("Types of gates: " + typeGate);
        System.out.println("Gatelist: " + gate.getGateList());
    }

    public Integer getAmountGates() {
        return amountGates;
    }

    public Integer getAmountEvents() {
        return amountEvents;
    }
}








/*
public void calcAmountGates(int difficulty, int knotGrade, int length){
        amountGates = Math.round((float)(difficulty + knotGrade + length)/3);
        if(knotGrade != length){
            amountGates = (int)Math.floor((float)amountGates * (float)(knotGrade/length));
        }

        if(length == 2){
            amountGates = (int)Math.ceil(amountGates * 1.51);
        }

        if(length == 3){
            amountGates = (int)Math.ceil(amountGates * 2);
        }

        if(amountGates == 0){
            amountGates++;
        }
        System.out.println("Anzahl Gates: " + amountGates);
    }

    public void calcAmountEvents(int difficulty, int knotGrade, int length){
        amountEvents = Math.round((float)(difficulty + knotGrade + length))*2;
        if(knotGrade < length){
            amountEvents = (int)Math.floor(amountEvents * 0.67);
        }

        if(knotGrade > length){
            amountEvents = (int)Math.ceil(amountEvents * 1.33);
        }
        System.out.println("Anzahl Events: " + amountEvents);

        for(int i = 0; i < amountEvents; i++)
        {
            Event evt = new Event(i, "Event Nr. " + i);
            eventList.addElement(evt);
        }
    }

    */