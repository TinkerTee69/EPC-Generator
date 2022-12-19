import java.util.List;

public class Loop extends RhombusOrLoop{

    public Loop(Integer kantenIndex, List<Object> list, Integer id, List<Kante> kantenList, Object refStart, Object refEnd) {
        super(kantenIndex, list, id, kantenList, refStart, refEnd);
        backwardKante kante2 = new backwardKante(id,id+1, refStart, refEnd);
        list.add(kante2);
        //kantenList.add(kante2);
    }
}
