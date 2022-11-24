import java.util.ArrayList;
import java.util.List;

public class mainProg {

    public static void main(String[] args) {
        Task task = new Task();
        generatorEPK generate_epk = new generatorEPK();
        randomTree2 rndTree = new randomTree2();
        task.setGates(generate_epk);
        task.setEvents(generate_epk);
        task.setFunctions(generate_epk);
        //task.setDifficulty();
        //task.setKnotGrade();
        //task.setLength();

        //generate_epk.calcAmountGates(task.getDifficulty(), task.getKnotGrade(), task.getLength());
        generate_epk.calcAmountEvents();
        generate_epk.calcAmountFunctions();
        generate_epk.randomizeTypeGate();

        generatorTask taskText = new generatorTask();


        //randomTree rndTree = new randomTree();

        rndTree.generateRandomTree(generate_epk.getAmountGates(), generate_epk.getTypeGate());

        EPK epk = new EPK();
        epk.show();


        mermaid m = new mermaid();
        m.generateMermaid(epk);

//        OR or = new OR();
//        List<Integer> position = new ArrayList<>();
//        List<Object> gates = new ArrayList<>();
//        position.add(1);
//        or.setPosition(position);
//        gateList gate = new gateList(gates);
//        gate.addElement(or);
//        System.out.println(gate.getPosition(or));

        //User interface for working on the task
        //new UI(epk);
    }
}