import java.util.*;

class randomTree {

    static void printTreeEdges(int[] arr, int amountGates)
    {
        int[] gate_set = new int[amountGates];

        for (int i = 0; i < amountGates; i++)
            gate_set[i] = 0;

        for (int i = 0; i < amountGates - 2; i++)
            gate_set[arr[i] - 1] += 1;

        System.out.print("\nRandom Tree wird wie folgt aufgebaut: \n");

        int j;
        for (int i = 0; i < amountGates - 2; i++) {
            for (j = 0; j < amountGates; j++) {
                if (gate_set[j] == 0) {
                    gate_set[j] = -1;
                    System.out.print("(" + (j + 1) + ", " + arr[i] + ") ");
                    gate_set[arr[i] - 1]--;
                    break;
                }
            }
        }

        j = 0;
        for (int i = 0; i < amountGates; i++) {
            if (gate_set[i] == 0 && j == 0) {
                System.out.print("(" + (i + 1) + ", ");
                j++;
            }
            else if (gate_set[i] == 0 && j == 1)
                System.out.print((i + 1) + ")\n");
        }
    }

    public void generateRandomTree(int amountGates)
    {

        Random rand = new Random();
        int[] arr = new int[amountGates - 2];

        for (int i = 0; i < amountGates-2; i++) {
            arr[i] = rand.nextInt(amountGates -1) + 1;
        }
        printTreeEdges(arr, amountGates);
    }
}