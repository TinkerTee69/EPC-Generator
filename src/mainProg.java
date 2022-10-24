public class mainProg {

    public static void main(String[] args) {
        Task task = new Task();
        task.setDifficulty();
        task.setKnotGrade();
        task.setLength();

        generatorEPK epk = new generatorEPK();
        epk.calcAmountGates(task.getDifficulty(), task.getKnotGrade(), task.getLength());
        epk.calcAmountEvents(task.getDifficulty(), task.getKnotGrade(), task.getLength());
        epk.calcAmountFunctions(epk.getAmountEvents());
        epk.randomizeTypeGate(task.getDifficulty(), epk.getTypeGate());

        generatorTask taskText = new generatorTask();
        //System.out.println(taskText.generateTaskText(task.getDifficulty(), task.getKnotGrade(), task.getLength()));


        randomTree rndTree = new randomTree();
        rndTree.generateRandomTree(epk.getAmountGates());

        //User interface for working on the task
    }
}