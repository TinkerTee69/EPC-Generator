import java.util.*;
public class generatorEPK {

    private Integer amountGates;
    private Integer amountEvents;
    private Integer amountFunctions;

    public List<String> getTypeGate() {
        return typeGate;
    }

    private List<String> typeGate = new ArrayList<>();
    private Integer amountAND = 0;
    private Integer amountOR = 0;
    private Integer amountXOR = 0;


    public Integer calcAmountGates(int difficulty, int knotGrade, int length){
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
        return amountGates;
    }

    public Integer calcAmountEvents(int difficulty, int knotGrade, int length){
        amountEvents = Math.round((float)(difficulty + knotGrade + length))*2;
        if(knotGrade < length){
            amountEvents = (int)Math.floor(amountEvents * 0.67);
        }

        if(knotGrade > length){
            amountEvents = (int)Math.ceil(amountEvents * 1.33);
        }
        System.out.println("Anzahl Events: " + amountEvents);
        return amountEvents;
    }

    public Integer calcAmountFunctions(int amountEvents) {
        amountFunctions = amountEvents -1;
        System.out.println("Anzahl Gates: " + amountFunctions);
        return amountFunctions;
    }

    public List<String> randomizeTypeGate(int difficulty, List<String> typeGate) {
        int i = 0;
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
        /*i = 0;
        while(i < typeGate.size()) {
            rnd = rand.nextInt(10);
            //if(rnd<5)
            i++;
        }*/
        System.out.println("Types of gates: " + typeGate);
        return typeGate;
    }

    public Integer getAmountGates() {
        return amountGates;
    }

    public Integer getAmountEvents() {
        return amountEvents;
    }
}
