import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Rhombus extends RhombusOrLoop{

    public Rhombus(Integer kantenIndex, List<Object> list, Integer id, List<Kante> kantenList, Object refStart, Object refEnd) {
        super(kantenIndex, list, id, kantenList, refStart, refEnd);
        ForwardKante kante2 = new ForwardKante(id,id+1, refStart, refEnd);
        list.add(kante2);
        kantenList.add(kante2);
    }
}
