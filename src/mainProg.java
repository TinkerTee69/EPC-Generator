public class mainProg {

    public static void main(String[] args) {
        Parameters parameters = new Parameters();
        GeneratorEPK generate_epk = new GeneratorEPK();
//        RandomTree rndTree = new RandomTree();
        parameters.setLoops(generate_epk);
        parameters.setRhomben(generate_epk);
//        parameters.setGates(generate_epk);
//        parameters.setEvents(generate_epk);
//        parameters.setFunctions(generate_epk);

        //generatorTask taskText = new generatorTask();

        //task.setDifficulty();
        //task.setKnotGrade();
        //task.setLength();
        //generate_epk.calcAmountGates(task.getDifficulty(), task.getKnotGrade(), task.getLength());

        generate_epk.setAmountGates((generate_epk.getAmountRhomben()));
        //generate_epk.calcAmountEvents();
        //generate_epk.calcAmountFunctions();
        generate_epk.randomizeTypeGate();

        EPK_new epk_new = new EPK_new(generate_epk);


        //rndTree.generateRandomTree(generate_epk.getAmountGates());

        //EPK epk = new EPK();
        //epk.show();


        Mermaid mermaid = new Mermaid();
        mermaid.generateMermaid(epk_new);

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