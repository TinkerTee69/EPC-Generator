import java.util.List;

public class gateList {
    private static List<Object> gateList;

    public static List<Object> getGateList() {
        return gateList;
    }

    public void setGateList(List<Object> gateList) {
        this.gateList = gateList;
    }

    public gateList(List<Object> gateList) {
        this.gateList = gateList;
    }


    public void addElement(AND and)
    {
//        gateType gate = new gateType(and);
        gateList.add(and);
    }

    public void addElement(XOR xor)
    {
//        gateType gate = new gateType(xor);
        gateList.add(xor);
    }

    public void addElement(OR or)
    {
//        gateType gate = new gateType(or);
        gateList.add(or);
        //gate.getClass();
        System.out.println(gateList);
    }

    public Integer getPosition(OR or)
    {
        return or.getPosition();
    }

}

