import java.util.ArrayList;
import java.util.List;

public class Mermaid {

    public void generateMermaid(EPK_new epk) {
        System.out.println("\n\n\nflowchart TD");
        int i = 0;
        while (epk.getList().size() > i)
        {
            if(epk.getList().get(i) instanceof EPK_Element && ((EPK_Element) epk.getList().get(i)).getType() instanceof Event)
            {
                System.out.println(((EPK_Element) epk.getList().get(i)).getId() + "" + "[" + (((EPK_Element) epk.getList().get(i)).getText()) + "]");
            }
            else if (epk.getList().get(i) instanceof EPK_Element && ((EPK_Element) epk.getList().get(i)).getType() instanceof Function) {
                System.out.println(((EPK_Element) epk.getList().get(i)).getId() + "" + "([" + (((EPK_Element) epk.getList().get(i)).getText()) + "])");
                //fctList.add(i);
            } else if (epk.getList().get(i) instanceof OrRhombus) {
                System.out.println(((OrRhombus) epk.getList().get(i)).getId() + "" + "{" + ((OrRhombus) epk.getList().get(i)).getId() + " OR}");
            } else if (epk.getList().get(i) instanceof XorRhombus) {
                System.out.println(((XorRhombus) epk.getList().get(i)).getId() + "" + "{" + ((XorRhombus) epk.getList().get(i)).getId() + " XOR}");
            } else if (epk.getList().get(i) instanceof AndRhombus) {
                System.out.println(((AndRhombus) epk.getList().get(i)).getId() + "" + "{" + ((AndRhombus) epk.getList().get(i)).getId() + " AND}");
            } else if (epk.getList().get(i) instanceof Loop) {
                System.out.println(((Loop) epk.getList().get(i)).getId() + "" + "{" + ((Loop) epk.getList().get(i)).getId() + " Loop OR}");
                System.out.println(((Loop) epk.getList().get(i)).getId()+1 + "" + "{" + (((Loop) epk.getList().get(i)).getId()+1) + " Loop XOR}");
            } else if (epk.getList().get(i) instanceof Kante) {
                System.out.println(((Kante) epk.getList().get(i)).getStartID() + " -->|" + ((Kante) epk.getList().get(i)).getKantenID() + "|" + ((Kante) epk.getList().get(i)).getEndID());
            }
            i++;
        }
        System.out.println();
    }
}
/*
        int i = 0;

        System.out.println("\n\n\nflowchart TD");
        List<Integer> gatePosition = epk.getGatePosition();
        List<Integer> fctList = new ArrayList<>();
        List<Integer> evtList = new ArrayList<>();


        while (epk.getEpkList().size() > i) {
            if (epk.getEpkList().get(i) instanceof Event) {
                System.out.println(i + "" + "[" + ((Event) epk.getEpkList().get(i)).getEventText() + "]");
                evtList.add(i);
            } else if (epk.getEpkList().get(i) instanceof Function) {
                System.out.println(i + "" + "([" + ((Function) epk.getEpkList().get(i)).getFunctionText() + "])");
                fctList.add(i);
            } else if (epk.getEpkList().get(i) instanceof OR) {
                System.out.println(i + "" + "{OR}");
            } else if (epk.getEpkList().get(i) instanceof XOR) {
                System.out.println(i + "" + "{XOR}");
            } else if (epk.getEpkList().get(i) instanceof AND) {
                System.out.println(i + "" + "{AND}");
            }

            i++;
        }


        i = 0;
        int i_fct = 0;
        int i_evt = 0;
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
//            try {
            while (gatePairs.length * 2 > j) {
                if(gatePairs[j/2][0] == gatePairs[j/2][1])
                {

                }
                else{

                    if (j % 2 == 0) {
                        System.out.print(gatePosition.get(-1 + gatePairs[j / 2][j % 2]) + " --> ");
                        System.out.println(fctList.get(i_fct));

                        System.out.println(fctList.get(i_fct) + " --> " + evtList.get(i_evt));
                        i_fct++;
                        i_evt++;
                    } else {
                        //System.out.println(gatePosition.get(-1 + gatePairs[j / 2][j % 2]));
                        System.out.println(i_evt + " --> " + gatePosition.get(-1 + gatePairs[j / 2][j % 2]));
                    }
                }
                j++;
            }
            // i++;
//            }catch(Exception e){}
        }*/

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




//import java.util.List;
//
//public class mermaid {
//
//    public void generateMermaid(EPK epk) {
//
//        int i = 0;
//
//        System.out.println("\n\n\nflowchart TD");
//        List<Integer> gatePosition = epk.getGatePosition();
//
//
//        while (epk.getEpkList().size() > i) {
//            if (epk.getEpkList().get(i) instanceof Event) {
//               // System.out.println(i + "" + "[" + ((Event) epk.getEpkList().get(i)).getEventText() + "]");
//            } else if (epk.getEpkList().get(i) instanceof Function) {
//                //System.out.println(i + "" + "([" + ((Function) epk.getEpkList().get(i)).getFunctionText() + "])");
//            } else if (epk.getEpkList().get(i) instanceof OR) {
//                System.out.println(i + "" + "{OR}");
//            } else if (epk.getEpkList().get(i) instanceof XOR) {
//                System.out.println(i + "" + "{XOR}");
//            } else if (epk.getEpkList().get(i) instanceof AND) {
//                System.out.println(i + "" + "{AND}");
//            }
//
////            if(i>0)
////            {
////                System.out.println(i-1 + " --> " + i);
////            }
//
//            i++;
//        }
//
//        //System.out.println("0 --> 1\n1 --> 2");
//
//        i = 0;
//        int j = 0;
//        int gate_id = 0;
//        int i_gate = 0;
//        int[][] translateArr = epk.getGatePairs_epk();
//        int[][] gatePairs = epk.getGatePairs_epk();
//        //while (epk.getEpkList().size() > i )
//        {
//            //if(epk.getEpkList().get(i) instanceof Function || epk.getEpkList().get(i) instanceof Event)
//            {
//                System.out.println();
//            }
////            try {
//                while (gatePairs.length * 2 > j) {
//                    if(gatePairs[j/2][0] == gatePairs[j/2][1])
//                    {
//
//                    }
//                    else{
//
//                        if (j % 2 == 0) {
//                            System.out.print(gatePosition.get(-1 + gatePairs[j / 2][j % 2]) + " --> ");
//                        } else {
//                            System.out.println(gatePosition.get(-1 + gatePairs[j / 2][j % 2]));
//                        }
//                    }
//                    j++;
//                }
//                // i++;
////            }catch(Exception e){}
//        }
//
////        try {
////            while (epk.getGatePairs_epk().length > i) {
////                while (epk.getEpkList().size() > j) {
////                    if (epk.getEpkList().get(j) instanceof AND || epk.getEpkList().get(j) instanceof OR || epk.getEpkList().get(j) instanceof XOR) {
////                        if (gate_id % 2 == 0) {
////                            System.out.print(gatePairs[j / 2][j % 2] + " --> ");
////                        } else {
////                            System.out.println(gatePairs[j / 2][j % 2]);
////                        }
////                        gate_id++;
////                    }
////                    j++;
////                }
////                System.out.println();
////                i++;
////            }
////        }catch (Exception e){}
//
//
////        try {
////            while (gatePairs.length * 2 > i) {
////                while (epk.getEpkList().size() > j) {
////                    if (gatePairs[i / 2][i % 2] == j) {
////                        translateArr[i / 2][i % 2] = gatePosition.get(i_gate);
////
////                        if (i % 2 == 0) {
////                            System.out.print(translateArr[i / 2][i % 2] + " --> ");
////                        } else {
////                            System.out.println(translateArr[i / 2][i % 2]);
////                        }
////                        i_gate++;
////                        continue;
////                    }
////
////                    j++;
////                }
////
////                i++;
////            }
////        }catch (Exception e){}
//
//
//    }
//}
