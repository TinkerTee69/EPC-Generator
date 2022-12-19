import java.util.*;
public class Parameters {

//    private Integer gates;
//    private Integer events;
//    private Integer functions;
    private Integer loops;
    private Integer rhomben;


    public void setLoops() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose amount of Loops: ");
        this. loops = Integer.parseInt(sc.nextLine());
    }


    public void setRhomben() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose amount of Rhomben: ");
        this.rhomben = Integer.parseInt(sc.nextLine());
    }

    public Integer getLoops() {
        return loops;
    }


    public Integer getRhomben() {
        return rhomben;
    }

}

/*
    public void setGates(GeneratorEPK generate_epk) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose amount of gates: ");
        this.gates = Integer.parseInt(sc.nextLine());
        generate_epk.setAmountGates(this.gates);
    }


    public void setEvents(GeneratorEPK generate_epk) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose amount of events: ");
        this.events = Integer.parseInt(sc.nextLine());
        generate_epk.setAmountEvents(this.events);
    }


    public void setFunctions(GeneratorEPK generate_epk) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose amount of Functions: ");
        this.functions = Integer.parseInt(sc.nextLine());
        generate_epk.setAmountFunctions(this.functions);
    }

    public Integer getLoops() {
        return loops;
    }

    public Integer getRhomben() {
        return rhomben;
    }
}

*/


    //    private Integer difficulty;
//    private Integer length;
//    private Integer knotGrade;

//    public Integer getKnotGrade() {
//        return knotGrade;
//    }
//
//    public void setKnotGrade() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Choose knot grade from 1 [linear] to  3 [complex]");
//        this.knotGrade = Integer.parseInt(sc.nextLine());
//    }
//
//    public Integer getDifficulty() {
//        return difficulty;
//    }
//
//    public void setDifficulty() {
//
//        System.out.println("Choose difficulty from 1 [easy] to 3 [hard]");
//        Scanner sc = new Scanner(System.in);
//        this.difficulty = Integer.parseInt(sc.nextLine());
//    }
//
//
//    public Integer getLength() {
//        return length;
//    }
//
//    public void setLength() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Choose process length from 1 [short] to 3 [long]");
//        this.length = Integer.parseInt(sc.nextLine());

