import java.util.*;
public class Task {

    private Integer difficulty;
    private Integer length;
    private Integer knotGrade;

    public Integer getKnotGrade() {
        return knotGrade;
    }

    public void setKnotGrade() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose knot grade from 1 [linear] to  3 [complex]");
        this.knotGrade = Integer.parseInt(sc.nextLine());
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty() {

        System.out.println("Choose difficulty from 1 [easy] to 3 [hard]");
        Scanner sc = new Scanner(System.in);
        this.difficulty = Integer.parseInt(sc.nextLine());
    }


    public Integer getLength() {
        return length;
    }

    public void setLength() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose process length from 1 [short] to 3 [long]");
        this.length = Integer.parseInt(sc.nextLine());
    }

}
