import java.util.*;

class RandomTree {
    public List<String> getGateList_tmp() {
        return gateList_tmp;
    }

    private final List<String> gateList_tmp = new ArrayList<>();
//    private static final ArrayList<ArrayList<Integer> > gates = new ArrayList<ArrayList<Integer> >();

    public static int[][] getGatePairs() {
        return gatePairs;
    }

    static void setGatePairs(int[][] gatePairs) {
        {
        }

    }

    private static int[][] gatePairs;// = new int[15][15];



    static void printTreeEdges(int[] arr, int amountGates)
    {
        gatePairs = new int[amountGates-1][2];
        int[] gate_set = new int[amountGates];

        // Initialisierung
        for (int i = 0; i < amountGates; i++)
            gate_set[i] = 0;

        // Befüllung mit den zufälligen Zahlen aus arr[]
        for (int i = 0; i < amountGates - 2; i++)
            gate_set[arr[i] - 1] += 1;

        System.out.print("\nRandom Tree wird wie folgt aufgebaut: \n");

        for (int i = 0; i < amountGates - 2; i++)
        {
            for (int j = 0; j < amountGates; j++) {
                // Wenn ein unbefülltes nur initialisiertes Element...
                if (gate_set[j] == 0)
                {
                    // ... setze dieses auf -1 (relevant für später, bedeutet es wurde befüllt)
                    gate_set[j] = -1;

                    // Befüllen der Pairs in der Reihenfolge [kleineres Element, größeres Element]
                    if(j+1 > arr[i])
                    {
//                        gateList_tmp.add("(" + arr[i] + " " + gateType.get(arr[i]-1) + " , " + (j + 1) + " " + gateType.get(j) + ") ");
                        gatePairs[i][0]=arr[i];
                        gatePairs[i][1]=(j+1);
                    }
                    else
                    {
//                        gateList_tmp.add("(" + (j + 1) + " " + gateType.get(j) + " , " + arr[i] + " " + gateType.get(arr[i]-1)+ ") ");
                        gatePairs[i][1]=arr[i];
                        gatePairs[i][0]=(j+1);

                    }
                    gate_set[arr[i] - 1]--;
                    break;
                }
            }
        }

        // befüllen der letzten Paare
        int j = 0;
        Random rand = new Random();
//        List<String> tempLastElements = new ArrayList<>();
        for (int i = 0; i < amountGates; i++)
        {
            if (i> 0 && gate_set[i] == 0 && j == 0 ||(gate_set[i] == 0 && j == 1)) {
//                tempLastElements.add((i + 1) + " " + gateType.get(i));
                gatePairs[i-1][0] = rand.nextInt(amountGates -1) + 1;
                gatePairs[i-1][1] = gatePairs[i-1][0] + 1;
                j++;
            }
//            else if (gate_set[i] == 0 && j == 1)
//            {
//                tempLastElements.add((i + 1) + " " + gateType.get(i));
//            }
        }
        if(gatePairs[gatePairs.length-1][0] > gatePairs[gatePairs.length-1][1])
        {
            int tempSwap = gatePairs[gatePairs.length-1][0];
            gatePairs[gatePairs.length-1][0] = gatePairs[gatePairs.length-1][1];
            gatePairs[gatePairs.length-1][1] = tempSwap;
        }

//                if(Character.getNumericValue(tempLastElements.get(0).charAt(0)) > Character.getNumericValue(tempLastElements.get(1).charAt(0)))
//                {
////                    gateList_tmp.add("(" + tempLastElements.get(1));
////                    gateList_tmp.add(tempLastElements.get(0) + ")");
//                    gatePairs[gatePairs.length-1][0] = Character.getNumericValue(tempLastElements.get(1).charAt(0));
//                    gatePairs[gatePairs.length-1][1] = Character.getNumericValue(tempLastElements.get(0).charAt(0));
////                    System.out.println(tempLastElements.get(0).charAt(0));
////                    System.out.println((Character.getNumericValue(tempLastElements.get(1).charAt(0))));
//                }
//                else
//                {
////                    gateList_tmp.add("(" + tempLastElements.get(0));
////                    gateList_tmp.add(tempLastElements.get(1) + ")");
//                    gatePairs[gatePairs.length-1][0] = Character.getNumericValue(tempLastElements.get(0).charAt(0));
//                    gatePairs[gatePairs.length-1][1] = Character.getNumericValue(tempLastElements.get(1).charAt(0));
////                    System.out.println(tempLastElements.get(0).charAt(0));
////                    System.out.println((Character.getNumericValue(tempLastElements.get(1).charAt(0))));
//                }
//
////        System.out.println(gateList_tmp);

        System.out.println(Arrays.deepToString(gatePairs));
        getNodes(gatePairs);
    }

    //Ebene hinzufügen (wird aktuell nicht verwendet)
    static void getNodes(int [][]gatePairs)
    {
        List<Integer> gatePairsList = new ArrayList<Integer>();

        System.out.println(Arrays.deepToString(gatePairs));
        for(int i = 0; gatePairs.length > i; i++)
        {
            for(int j = 0; j < 2; j++)
            {
                for(int k = i+1; gatePairs.length > k; k++)
                {
                    if(gatePairs[i][j] == gatePairs[k][j])
                    {
                        gatePairsList.add(gatePairs[i][j]);
                    }
                }
        System.out.println(gatePairsList);
            }
        }
    }

    public void generateRandomTree(int amountGates)
    {

        Random rand = new Random();
        int[] arr = new int[amountGates - 2];

        //n-1 Verbindungen für RandomTree erstellen
        for (int i = 0; i < amountGates-2; i++)
        {
            arr[i] = rand.nextInt(amountGates -1) + 1;
        }

        //Funktion für die Herstellung der Verbindung
        printTreeEdges(arr, amountGates);
    }
}