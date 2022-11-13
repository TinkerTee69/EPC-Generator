import java.util.ArrayList;
import java.util.List;

public class mainProg {

    public static void main(String[] args) {
        Task task = new Task();
        task.setDifficulty();
        task.setKnotGrade();
        task.setLength();

        generatorEPK generate_epk = new generatorEPK();
        generate_epk.calcAmountGates(task.getDifficulty(), task.getKnotGrade(), task.getLength());
        generate_epk.calcAmountEvents(task.getDifficulty(), task.getKnotGrade(), task.getLength());
        generate_epk.calcAmountFunctions(generate_epk.getAmountEvents());
        generate_epk.randomizeTypeGate(task.getDifficulty(), generate_epk.getTypeGate());

        generatorTask taskText = new generatorTask();
        //System.out.println(taskText.generateTaskText(task.getDifficulty(), task.getKnotGrade(), task.getLength()));


        //randomTree rndTree = new randomTree();
        randomTree2 rndTree = new randomTree2();
        rndTree.generateRandomTree(generate_epk.getAmountGates(), generate_epk.getTypeGate());

        EPK epk = new EPK();
        System.out.println(epk.getEvtList_epk());

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