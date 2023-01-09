import java.util.*;
public class Parameters {
    private Integer loops;
    private Integer rhomben;
    private Integer minElements;
    private Integer maxElements;

    public Parameters() {
        do {
            setLoops();
            setRhomben();
        }while(rhomben+loops<1);
        setMinElements();
        setMaxElements();
    }
    public Parameters(int i) {
        setLoops(1);
        setMaxElements(3);
        setMinElements(1);
        setRhomben(5);
    }


    public void setLoops() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose amount of Loops: ");
        this.loops = Integer.parseInt(sc.nextLine());
    }


    public void setRhomben() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose amount of Rhomben: ");
        this.rhomben = Integer.parseInt(sc.nextLine());
    }

    public void setMinElements(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Choose minimum of Elements between gates: ");
            this.minElements = Integer.parseInt(sc.nextLine());
        }while(2 > minElements);
    }

    public void setMaxElements(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Choose maximum of Elements between gates: ");
            this.maxElements = Integer.parseInt(sc.nextLine());
        }while(maxElements < getMinElements());
    }

    public Integer getLoops() {
        return loops;
    }


    public Integer getRhomben() {
        return rhomben;
    }

    public Integer getMinElements() {
        return minElements;
    }

    public Integer getMaxElements() {
        return maxElements;
    }

    public void setLoops(Integer loops) {
        this.loops = loops;
    }

    public void setRhomben(Integer rhomben) {
        this.rhomben = rhomben;
    }

    public void setMinElements(Integer minElements) {
        this.minElements = minElements;
    }

    public void setMaxElements(Integer maxElements) {
        this.maxElements = maxElements;
    }
}