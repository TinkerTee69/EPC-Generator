import java.util.List;

public class Mermaid {

    public void generateMermaid(EPK_new epk) {
        Integer id, endId;
        System.out.println("\n\n\ndigraph EPK_Edotor {rankdir=TD;\nsize=\"8,5\"");
        int i = 0;
        List<Object> list = epk.getList();
        while (list.size() > i)
        {
            if(list.get(i) instanceof Event)
            {
                System.out.println(((Event) list.get(i)).getId() +  "[label=\"" + ((Event) list.get(i)).getEventText() + "\", shape = hexagon];");
            }
            else if (list.get(i) instanceof Kante) {
                id = ((Kante) list.get(i)).getId((EPK_Element) ((Kante) list.get(i)).getRefStart());
                endId = ((Kante) list.get(i)).getId((EPK_Element) ((Kante) list.get(i)).getRefEnd());
                System.out.println(id + " -> " + endId + "[ label = \"" + ((Kante) list.get(i)).getKantenID() + "\" ]");
            }
            else if (list.get(i) instanceof Function) {
                System.out.println(((Function) list.get(i)).getId() + "[label=\"" + ((Function) list.get(i)).getFunctionText() + "\", style=rounded];");
            }
            else {
                id = ((RhombusOrLoop) list.get(i)).getId((Gate) ((RhombusOrLoop) list.get(i)).getRefStart());
                endId = ((RhombusOrLoop) list.get(i)).getId((Gate) ((RhombusOrLoop) list.get(i)).getRefEnd());
                if (list.get(i) instanceof OrRhombus) {
                    System.out.println(id + " [label=\"OR\", shape = circle];");
                    System.out.println((endId) + " [label=\"OR\", shape = circle];");
                } else if (list.get(i) instanceof XorRhombus) {
                    System.out.println(id + " [label=\"XOR\", shape = circle];");
                    System.out.println((endId) + " [label=\"XOR\", shape = circle];");
                } else if (list.get(i) instanceof AndRhombus) {
                    System.out.println(id + "[label=\"AND\", shape = circle];");
                    System.out.println(endId + " [label=\"AND\", shape = circle];");
                } else if (list.get(i) instanceof Loop) {
                    System.out.println(id + "  [label=\"OR\", shape = circle];");
                    System.out.println((endId) + " [label=\"XOR\", shape = circle];");
                }
            }
            i++;
        }
        System.out.println("}");
    }
}