import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EPK {
    Random rnd = new Random();

    public int[][] getGatePairs_tmp() {
        return gatePairs_tmp;
    }

    private int[][] gatePairs_tmp;

    public List<Integer> getGatePosition() {
        return gatePosition;
    }

    public void setGatePosition(List<Integer> gatePosition) {
        this.gatePosition = gatePosition;
    }

    List<Integer> gatePosition = new ArrayList<>();
    public EPK(int[][] gatePairs, List<Object> gateList_epk, List<Object> fctList_epk, List<Object> evtList_epk, List<Object> epkList) {
        this.gatePairs = gatePairs;
        this.gateList_epk = gateList_epk;
        this.fctList_epk = fctList_epk;
        this.evtList_epk = evtList_epk;
        this.epkList = epkList;
    }

    public EPK() {
        gatePairs = getGatePairs();
        gateList_epk = getGateList_epk();
        fctList_epk = getFctList_epk();
        evtList_epk = getEvtList_epk();
        epkList = buildEPK();
        //gatePairs_epk = gatePairs;
    }

    public List<Object> buildEPK(){
        setGatePairs(randomTree2.getGatePairs());
        gatePairs_epk = getGatePairs();

        int leftGatePair = 0;
        int rightGatePair = 0;
        int i = 0;
        int i_gate = 0;
        int i_fct = 0;
        int i_evt = 0;
        int i_loop = 0;
//        while(i_gate < gateList_epk.size() || i_fct < fctList_epk.size() || i_evt < evtList_epk.size())
        while(i < (gateList_epk.size() + functionList.getFctList().size() + eventList.getEvtList().size()))
        {
//            System.out.println((gateList_epk.size() + functionList.getFctList().size() + eventList.getEvtList().size()) + " i:" + i);
            if(i==0)
            {
                epkList.add(eventList.getEvtList().get(i_evt));
                i_evt++;
            }
            else if(i==1)
            {
                epkList.add(functionList.getFctList().get(i_fct));
                i_fct++;
            }
            else if((epkList.get(i-1) instanceof Event || epkList.get(i-1) instanceof AND)
                    && (i+rnd.nextInt(4))%4==0
                    && functionList.getFctList().size() > i_fct
                    )
            {
                if(epkList.get(i-1) instanceof  Event)
                {
                    epkList.add(functionList.getFctList().get(i_fct));
                    i_fct++;
                    i_loop=0;
                }
                else if((epkList.get(i-1) instanceof AND && !(epkList.get(i-2) instanceof Function)))
                {
                    epkList.add(functionList.getFctList().get(i_fct));
                    i_fct++;
                    i_loop=0;
                }
                else {
                    i--;
                }
            }
            else if(!(epkList.get(i-1) instanceof Event)
                    && (i+rnd.nextInt(4))%4==1
                    && eventList.getEvtList().size() > i_evt)
            {

                if((epkList.get(i-1) instanceof AND || epkList.get(i-1) instanceof OR  || epkList.get(i-1) instanceof XOR) && !(epkList.get(i-2) instanceof Event))
                {
                    epkList.add(eventList.getEvtList().get(i_evt));
                    i_evt++;
                    i_loop=0;
                }
                else if(epkList.get(i-1) instanceof Function)
                {
                    epkList.add(eventList.getEvtList().get(i_evt));
                    i_evt++;
                    i_loop=0;
                }
                else
                {
                    i--;
                }
            }
            else if(gateList_epk.size() > i_gate
                    && (epkList.get(i-1) instanceof Function
                    || (epkList.get(i-1) instanceof Event && !(gateList_epk.get(i_gate) instanceof OR)) && !(gateList_epk.get(i_gate) instanceof XOR)))
            {
                epkList.add(gateList_epk.get(i_gate));
                //if(i_gate%2==0)
                {
                    //leftGatePair = i_gate/2;
                    //rightGatePair = i_gate%2;
//                    gatePairs_epk[leftGatePair][rightGatePair] = i;
                    //übersetzung random tree nr zu epkliste
                    //gatePairs_epk[i_gate][1] = i;
                    gatePosition.add(i);


                }
                i_gate++;
                i_loop=0;
            }

            else
            {
                //System.out.println("random " + rnd.nextInt(3));
                i_loop++;
                i--;
                if(i_loop == 20)
                {
                    break;
                }

            }
            i++;
            //show();
        }

        // Verbindung gates ohne vorherige Verbindungen mit zufälligen vorherigen Gate
        i = 0;
        int j = gatePairs.length;
        int k = 0;
        boolean connectedFlag = false;
        int amountAddGate = 0;
        while(gatePairs_epk.length > i)
        {
            j = gatePairs.length;
            while(j > 0)
            {
                if(gatePairs_epk[i][0] == gatePairs_epk[j-1][1] || gatePairs_epk[i][0] == 1)
                {
                    connectedFlag = true;
                    break;
                }
                j--;
            }
            if(amountAddGate > 0 && connectedFlag == false)
            {
                connectedFlag = checkGatePairsTmp(gatePairs_epk[i][0]);
            }
            if(connectedFlag == false)
            {
                amountAddGate++;
                if(amountAddGate>1)
                {
                    int[][] gatePairs_tmp = new int[gatePairs_epk.length+amountAddGate][2];
                    int[][] gatePairs_tmp2 = getGatePairs_tmp();
                    int q = 0;
                    while(gatePairs_tmp2.length-1 > q)
                    {
                        gatePairs_tmp[q][0] = gatePairs_tmp2[q][0];
                        gatePairs_tmp[q][1] = gatePairs_tmp2[q][1];
                        System.out.print("hier hängtsY");
                        q++;
                    }
                }
                else
                {
                    int[][] gatePairs_tmp = new int[gatePairs_epk.length+amountAddGate][2];
                    while(gatePairs_tmp.length-1 > k)
                    {
                        gatePairs_tmp[k][0] = gatePairs_epk[k][0];
                        gatePairs_tmp[k][1] = gatePairs_epk[k][1];
                        k++;
                    }
                    k = 0;
                    setTmpGatePairs(gatePairs_tmp);
                }
                //gatePairs = gatePairs_epk;
                //gatePairs_tmp = getGatePairs_tmp();
                //if(gatePairs_tmp.length < gatePairs_epk.length +2)



                    gatePairs_tmp[gatePairs_tmp.length-1][0] = rnd.nextInt(gatePairs_epk[i][0]+1);
                    while(gatePairs_tmp[gatePairs_tmp.length-1][0] >= gatePairs_epk[i][0])
                    {
                        gatePairs_tmp[gatePairs_tmp.length-1][0] = gatePairs_epk[i][0]-1;
                    }
                    if(gatePairs_tmp[gatePairs_tmp.length-1][0] < 1)
                    {
                        gatePairs_tmp[gatePairs_tmp.length-1][0] = 1;
                    }

                    gatePairs_tmp[gatePairs_tmp.length-1][1] = gatePairs_epk[i][0];


                setTmpGatePairs(gatePairs_tmp);
            }
            else
            {
                connectedFlag = false;
            }
            i++;

        }

        setGatePosition(gatePosition);
        if(getGatePairs_tmp().length > 0)
        {
            setGatePairs_epk(getGatePairs_tmp());
        }
        else
        {
            setGatePairs_epk(getGatePairs());
        }
        return epkList;
    }

    public boolean checkGatePairsTmp(int checkNumber)
    {
        int[][] gateCheck = getGatePairs_tmp();
        int i = 0;
        boolean connectedFlag = false;

        while(gateCheck.length > i)
        {
            if(gateCheck[i][1] == checkNumber)
            {
                connectedFlag = true;
            }
            i++;
        }


        return connectedFlag;
    }

    public void setTmpGatePairs(int[][] gatePairs_tmp)
    {
        this.gatePairs_tmp = gatePairs_tmp;
    }

    public void show()
    {
        int i = 0;
        int i_gate = 0;
        int i_fct = 0;
        int i_evt = 0;
        while(i < epkList.size())
        {
            System.out.println(epkList.get(i));
            if(epkList.get(i) instanceof  Event)
            {
                i_evt++;
            }
            else if(epkList.get(i) instanceof  Function)
            {
                i_fct++;
            }
            else if(epkList.get(i) instanceof  OR || epkList.get(i) instanceof XOR ||epkList.get(i) instanceof AND)
            {
                i_gate++;
            }
            i++;
        }
        System.out.println("Functions: " + i_fct + ", Events: " + i_evt + ", Gates: " + i_gate);
    }

    public void setGateList_epk(gateList gateList_epk) {
        this.gateList_epk = gateList.getGateList();
    }

    public void setGatePairs(int[][] gatePairs) {
        this.gatePairs = randomTree2.getGatePairs();
    }


    public int[][] getGatePairs() {
        return gatePairs;
    }

    public List<Object> getGateList_epk() {
        return gateList.getGateList();
    }

    public List getFctList_epk() {
        return functionList.getFctList();
    }

    public void setFctList_epk(List fctList_epk) {
        this.fctList_epk = fctList_epk;
    }

    public List getEvtList_epk() {
        return eventList.getEvtList();
    }

    public void setEvtList_epk(List evtList_epk) {
        this.evtList_epk = evtList_epk;
    }

    public List<Object> getEpkList() {
        return epkList;
    }

    public void setEpkList(List<Object> epkList) {
        this.epkList = epkList;
    }


    public int[][] getGatePairs_epk() {
        return gatePairs_epk;
    }

    public void setGatePairs_epk(int[][] gatePairs_epk) {
        this.gatePairs_epk = gatePairs_epk;
    }

    private int[][] gatePairs_epk;
    private int[][] gatePairs;

    private List<Object> gateList_epk;
    private List<Object> fctList_epk;
    private List<Object> evtList_epk;
    private List<Object> epkList = new ArrayList<>();
}
