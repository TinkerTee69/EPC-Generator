import java.util.*;
public class Parameters {
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