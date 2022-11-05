import java.util.*;

class randomTree2 {
    public List<String> getGateList() {
        return gateList;
    }

    private final List<String> gateList = new ArrayList<>();

    static void printTreeEdges(int[] arr, int amountGates, List<String> gateType, List<String> gateList)
    {
        int[] gate_set = new int[amountGates];

        for (int i = 0; i < amountGates; i++)
            gate_set[i] = 0;

        for (int i = 0; i < amountGates - 2; i++)
            gate_set[arr[i] - 1] += 1;

        System.out.print("\nRandom Tree wird wie folgt aufgebaut: \n");

        int j;
        for (int i = 0; i < amountGates - 2; i++)
        {
            for (j = 0; j < amountGates; j++) {
                if (gate_set[j] == 0)
                {
                    gate_set[j] = -1;
                    if(j+1 > arr[i])
                    {
                        gateList.add("(" + arr[i] + " " + gateType.get(arr[i]-1) + " , " + (j + 1) + " " + gateType.get(j) + ") ");
                    }
                    else
                    {
                        gateList.add("(" + (j + 1) + " " + gateType.get(j) + " , " + arr[i] + " " + gateType.get(arr[i]-1)+ ") ");
                    }
                    gate_set[arr[i] - 1]--;
                    break;
                }
            }
        }

        j = 0;
        List<String> tempLastElements = new ArrayList<>();
        for (int i = 0; i < amountGates; i++)
        {
            if (gate_set[i] == 0 && j == 0) {
                tempLastElements.add((i + 1) + " " + gateType.get(i));
                j++;

            }
            else if (gate_set[i] == 0 && j == 1)
            {
                tempLastElements.add((i + 1) + " " + gateType.get(i));
            }
        }
                if(Character.getNumericValue(tempLastElements.get(0).charAt(0)) > Character.getNumericValue(tempLastElements.get(1).charAt(0)))
                {
                    gateList.add("(" + tempLastElements.get(1));
                    gateList.add(tempLastElements.get(0) + ")");
                }
                else
                {
                    gateList.add("(" + tempLastElements.get(0));
                    gateList.add(tempLastElements.get(1) + ")");
                }

        System.out.println(gateList);
    }

    public void generateRandomTree(int amountGates, List<String> gateType)
    {

        Random rand = new Random();
        int[] arr = new int[amountGates - 2];

        for (int i = 0; i < amountGates-2; i++)
        {
            arr[i] = rand.nextInt(amountGates -1) + 1;
        }
        printTreeEdges(arr, amountGates, gateType, gateList);
    }
}