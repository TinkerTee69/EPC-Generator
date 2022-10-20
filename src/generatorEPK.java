public class generatorEPK {
    private String taskText;

    private Integer amountGates;
    private Integer amountEvents;
    private Integer amountFunctions;

    public void generateEPK(int difficulty, int knotGrade, int length){

        amountGates = calcAmountGates(difficulty, knotGrade, length);
    }

    public Integer calcAmountGates(int difficulty, int knotGrade, int length){
        amountGates = (int)Math.round((float)(difficulty + knotGrade + length)/3);
        if(knotGrade > length){
            amountGates = (int)Math.floor(amountGates * 0.67);
        }

        if(knotGrade < length){
            amountGates = (int)Math.ceil(amountGates * 1.33);
        }
        return amountGates;
    }

    public Integer calcAmountEvents(int difficulty, int knotGrade, int length){
        amountEvents = (int)Math.round((float)(difficulty + knotGrade + length))*2;
        if(knotGrade < length){
            amountEvents = (int)Math.floor(amountEvents * 0.67);
        }

        if(knotGrade > length){
            amountEvents = (int)Math.ceil(amountEvents * 1.33);
        }
        return amountEvents;
    }

    public Integer calcAmountFunctions(int difficulty, int knotGrade, int length, int amountEvents) {
        amountFunctions = amountEvents -1;
        return amountFunctions;
    }



    public Integer getAmountGates() {
        return amountGates;
    }
}
