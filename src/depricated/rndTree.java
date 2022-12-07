package depricated;

import java.util.*;

class rndTree {
    public List<String> getGateList() {
        return gateList;
    }

    public static void setGateList(String addElement) {
        gateList.add(addElement);

    }

    private static List<String> gateList;

    static void printTreeEdges(int[] arr, int amountGates, List<String> gateType)
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

                    {
                        System.out.print("(" + (j + 1) + " " + gateType.get(j) + " , " + arr[i] + " " + gateType.get(arr[i]-1)+ ") ");
                    }
                    gate_set[arr[i] - 1]--;
                    break;
                }
            }
        }

        j = 0;
        for (int i = 0; i < amountGates; i++) {
            if (gate_set[i] == 0 && j == 0) {
                //System.out.print("(" + (i + 1) + " " + gateType.get(i) + ", ");
                {
                    System.out.print("(" + (i + 1) + " " + gateType.get(i) + ", ");
                }
                j++;
            }
            else if (gate_set[i] == 0 && j == 1)
                System.out.print((i + 1) + " " + gateType.get(i) + ")\n");
        }
        //System.out.println(Arrays.toString(arr));
    }

    public void generateRandomTree(int amountGates, List<String> gateType)
    {

        Random rand = new Random();
        int[] arr = new int[amountGates - 2];

        for (int i = 0; i < amountGates-2; i++) {
            arr[i] = rand.nextInt(amountGates -1) + 1;
        }
        printTreeEdges(arr, amountGates, gateType);
    }
}