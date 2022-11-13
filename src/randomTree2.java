import java.util.*;

class randomTree2 {
    public List<String> getGateList_tmp() {
        return gateList_tmp;
    }

    private final List<String> gateList_tmp = new ArrayList<>();
    //int [][]gates = new int[][];
    private static final ArrayList<ArrayList<Integer> > gates = new ArrayList<ArrayList<Integer> >();

    public static int[][] getGatePairs() {
        return gatePairs;
    }

    public static void setGatePairs(int[][] gatePairs) {
        randomTree2.gatePairs = gatePairs;
    }

    private static int[][] gatePairs;// = new int[15][15];

    static void printTreeEdges(int[] arr, int amountGates, List<String> gateType, List<String> gateList_tmp)
    {
        //gates.add(new ArrayList<Integer>());
        gatePairs = new int[amountGates-1][2];
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
                        gateList_tmp.add("(" + arr[i] + " " + gateType.get(arr[i]-1) + " , " + (j + 1) + " " + gateType.get(j) + ") ");

                        //gates.get(0).add(arr[i], (j+1));
                        gatePairs[i][0]=arr[i];
                        gatePairs[i][1]=(j+1);
                    }
                    else
                    {
                        gateList_tmp.add("(" + (j + 1) + " " + gateType.get(j) + " , " + arr[i] + " " + gateType.get(arr[i]-1)+ ") ");
                        //gates.add((j), arr[i]);
                        gatePairs[i][1]=arr[i];
                        gatePairs[i][0]=(j+1);

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
                    gateList_tmp.add("(" + tempLastElements.get(1));
                    gateList_tmp.add(tempLastElements.get(0) + ")");
                    //gates.get(0).add(Integer.valueOf(tempLastElements.get(0)));
                    gatePairs[gatePairs.length-1][0] = Character.getNumericValue(tempLastElements.get(1).charAt(0));
                    gatePairs[gatePairs.length-1][1] = Character.getNumericValue(tempLastElements.get(0).charAt(0));
                    System.out.println(tempLastElements.get(0).charAt(0));
                    System.out.println((Character.getNumericValue(tempLastElements.get(1).charAt(0))));
                }
                else
                {
                    gateList_tmp.add("(" + tempLastElements.get(0));
                    gateList_tmp.add(tempLastElements.get(1) + ")");
                    gatePairs[gatePairs.length-1][0] = Character.getNumericValue(tempLastElements.get(0).charAt(0));
                    gatePairs[gatePairs.length-1][1] = Character.getNumericValue(tempLastElements.get(1).charAt(0));
                    //gates.get(0).add(Integer.valueOf(tempLastElements.get(1)));
                    System.out.println(tempLastElements.get(0).charAt(0));
                    System.out.println((Character.getNumericValue(tempLastElements.get(1).charAt(0))));
                }

        System.out.println(gateList_tmp);
        System.out.println(Arrays.deepToString(gatePairs));
        treeGateRandomizeEndings(gatePairs);
    }

    static void treeGateRandomizeEndings(int [][]gatePairs)
    {
        List<int[][]> gateList = new ArrayList<int[][]>();
        gateList.add(gatePairs);
        int[][] temp = {{0,0},{0,0}};

        //ArrayList<int[][]> list = new ArrayList<int[][]>(gateList);
        //System.out.println(list);
        System.out.println(Arrays.deepToString(gatePairs));
        System.out.println(Arrays.deepToString(gateList.get(0)));
        int count = 1;
        for(int i = 0; gatePairs.length > i; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                for(int k = i+1; gatePairs.length > k; k++)
                {
                    if(gatePairs[i][j] == gatePairs[k][j])
                    {
                        //System.out.println("Joooo");
                        count++;
                        temp[0][0] = gatePairs[k][j];
                        temp[0][1] = gatePairs[i][j];
                        gateList.add(temp);
                        System.out.println(Arrays.deepToString(gateList.get(1)));
                    }
                }

            }
//            if(count > 1)
//            {
//                gateList.add(temp);
//                count = 1;
//            }
        }

    }

    public void generateRandomTree(int amountGates, List<String> gateType)
    {

        Random rand = new Random();
        int[] arr = new int[amountGates - 2];

        for (int i = 0; i < amountGates-2; i++)
        {
            arr[i] = rand.nextInt(amountGates -1) + 1;
        }
        printTreeEdges(arr, amountGates, gateType, gateList_tmp);
    }
}