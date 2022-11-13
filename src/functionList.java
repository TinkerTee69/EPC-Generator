import java.util.List;

public class functionList {
    public functionList() {
    }
    public functionList(List<Object> fctList) {
        this.fctList = fctList;
    }

    public static List<Object> getFctList() {
        return fctList;
    }

    public static void setFctList(List<Object> fctList) {
        functionList.fctList = fctList;
    }

    public static void addElement(Function fct)
    {
        fctList.add(fct);
    }

    private static List<Object> fctList;


}
