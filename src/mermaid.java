import java.util.List;

public class mermaid {

    public void generateMermaid(EPK epk) {

        int i = 0;

        System.out.println("flowchart TD");
        List<Integer> gatePosition = epk.getGatePosition();

        while (epk.getEpkList().size() > i) {
            if (epk.getEpkList().get(i) instanceof Event) {
                System.out.println(i + "" + "[" + ((Event) epk.getEpkList().get(i)).getEventText() + "]");
            } else if (epk.getEpkList().get(i) instanceof Function) {
                System.out.println(i + "" + "([" + ((Function) epk.getEpkList().get(i)).getFunctionText() + "])");
            } else if (epk.getEpkList().get(i) instanceof OR) {
                System.out.println(i + "" + "{OR}");
            } else if (epk.getEpkList().get(i) instanceof XOR) {
                System.out.println(i + "" + "{XOR}");
            } else if (epk.getEpkList().get(i) instanceof AND) {
                System.out.println(i + "" + "{AND}");
            }

//            if(i>0)
//            {
//                System.out.println(i-1 + " --> " + i);
//            }

            i++;
        }

        System.out.println("1 --> 2\n2 --> 3");

        i = 0;
        int j = 0;
        int gate_id = 0;
        int i_gate = 0;
        int[][] translateArr = epk.getGatePairs_epk();
        int[][] gatePairs = epk.getGatePairs_epk();
        //while (epk.getEpkList().size() > i )
        {
            //if(epk.getEpkList().get(i) instanceof Function || epk.getEpkList().get(i) instanceof Event)
            {
                System.out.println();
            }
            while (gatePairs.length*2 > j) {
                if(j%2==0)
                {
                    System.out.print(gatePosition.get(-1 + gatePairs[j/2][j%2]) + " --> ");
                }
                else
                {
                    System.out.println(gatePosition.get(-1 + gatePairs[j/2][j%2]));
                }
                j++;
            }
           // i++;
        }

//        try {
//            while (epk.getGatePairs_epk().length > i) {
//                while (epk.getEpkList().size() > j) {
//                    if (epk.getEpkList().get(j) instanceof AND || epk.getEpkList().get(j) instanceof OR || epk.getEpkList().get(j) instanceof XOR) {
//                        if (gate_id % 2 == 0) {
//                            System.out.print(gatePairs[j / 2][j % 2] + " --> ");
//                        } else {
//                            System.out.println(gatePairs[j / 2][j % 2]);
//                        }
//                        gate_id++;
//                    }
//                    j++;
//                }
//                System.out.println();
//                i++;
//            }
//        }catch (Exception e){}


//        try {
//            while (gatePairs.length * 2 > i) {
//                while (epk.getEpkList().size() > j) {
//                    if (gatePairs[i / 2][i % 2] == j) {
//                        translateArr[i / 2][i % 2] = gatePosition.get(i_gate);
//
//                        if (i % 2 == 0) {
//                            System.out.print(translateArr[i / 2][i % 2] + " --> ");
//                        } else {
//                            System.out.println(translateArr[i / 2][i % 2]);
//                        }
//                        i_gate++;
//                        continue;
//                    }
//
//                    j++;
//                }
//
//                i++;
//            }
//        }catch (Exception e){}


    }
}
