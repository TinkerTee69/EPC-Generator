import java.util.List;

public class Rhombus extends RhombusOrLoop{


    public Rhombus(Integer kantenIndex, List<Object> list, List<Kante> kantenList, Object refStart, Object refEnd, Parameters parameters) {
        super(kantenIndex, list, kantenList, refStart, refEnd, parameters);
        ForwardKante kante2 = new ForwardKante(refStart, refEnd);
        list.add(kante2);
        kantenList.add(kante2);
    }
}
