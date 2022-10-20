public class generatorEPK {
    private String taskText;



    private Integer amountGates;

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




    public Integer getAmountGates() {
        return amountGates;
    }
}
