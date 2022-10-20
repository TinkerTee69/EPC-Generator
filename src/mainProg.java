import java.util.Scanner;

public class mainProg {

    public static void main(String[] args) {
        //Task properties
        Task task = new Task();


    System.out.println("Choose difficulty from 1 [easy] to 3 [hard]");
        Scanner sc = new Scanner(System.in);
        task.setDifficulty(Integer.parseInt(sc.nextLine()));

        System.out.println("Choose knot grade from 1 [linear] to  3 [complex]");
        task.setKnotGrade(Integer.parseInt(sc.nextLine()));

        System.out.println("Choose process length from 1 [short] to 3 [long]");
        task.setLength(Integer.parseInt(sc.nextLine()));

        generatorEPK epk = new generatorEPK();

        System.out.println("You choose a " + task.getDifficulty() + " difficult, " + task.getKnotGrade() +
                " knot graded and " + task.getLength() + " long task.\n Anzahl Gates: " + epk.calcAmountGates(
                        task.getDifficulty(), task.getKnotGrade(), task.getLength()));

        generatorTask taskText = new generatorTask();
        System.out.println(taskText.generateTaskText(task.getDifficulty(), task.getKnotGrade(), task.getLength()));

        //User interface for working on the task
    }
}