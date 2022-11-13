import java.util.ArrayList;
import java.util.List;

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


        //randomTree rndTree = new randomTree();
        randomTree2 rndTree = new randomTree2();
        rndTree.generateRandomTree(epk.getAmountGates(), epk.getTypeGate());


//        OR or = new OR();
//        List<Integer> position = new ArrayList<>();
//        List<Object> gates = new ArrayList<>();
//        position.add(1);
//        or.setPosition(position);
//        gateList gate = new gateList(gates);
//        gate.addElement(or);
//        System.out.println(gate.getPosition(or));

        //User interface for working on the task
        //new UI();
    }
}