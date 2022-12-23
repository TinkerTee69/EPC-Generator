public class Mermaid {

    public void generateMermaid(EPK_new epk) {
        Integer id, endId;
        System.out.println("\n\n\ndigraph EPK_Edotor {rankdir=TD;\nsize=\"8,5\"");
        int i = 0;
        while (epk.getList().size() > i)
        {
            if(epk.getList().get(i) instanceof Event)
            {
                System.out.println(((Event) epk.getList().get(i)).getId() +  "[label=\"" + ((Event) epk.getList().get(i)).getEventText() + "\", shape = haxagon];");
            }
            else if (epk.getList().get(i) instanceof Kante) {
                id = ((Kante) epk.getList().get(i)).getId((EPK_Element) ((Kante) epk.getList().get(i)).getRefStart());
                endId = ((Kante) epk.getList().get(i)).getId((EPK_Element) ((Kante) epk.getList().get(i)).getRefEnd());
                System.out.println(id + " -> " + endId + "[ label = \"" + ((Kante) epk.getList().get(i)).getKantenID() + "\" ]");
            }
            else if (epk.getList().get(i) instanceof Function) {
                System.out.println(((Function) epk.getList().get(i)).getId() + "[label=\"" + ((Function) epk.getList().get(i)).getFunctionText() + "\", style=rounded];");
            } else if (epk.getList().get(i) instanceof OrRhombus) {
                id = ((OrRhombus) epk.getList().get(i)).getId((OR) ((OrRhombus) epk.getList().get(i)).getRefStart());
                endId = ((OrRhombus) epk.getList().get(i)).getId((OR) ((OrRhombus) epk.getList().get(i)).getRefEnd());
                System.out.println(id + " [label=\"OR\", shape = circle];");
                System.out.println((endId) + " [label=\"OR\", shape = circle];");
            } else if (epk.getList().get(i) instanceof XorRhombus) {
                id = ((XorRhombus) epk.getList().get(i)).getId((XOR) ((XorRhombus) epk.getList().get(i)).getRefStart());
                endId = ((XorRhombus) epk.getList().get(i)).getId((XOR) ((XorRhombus) epk.getList().get(i)).getRefEnd());
                System.out.println(id + " [label=\"XOR\", shape = circle];");
                System.out.println((endId) + " [label=\"XOR\", shape = circle];");
            } else if (epk.getList().get(i) instanceof AndRhombus) {
                id = ((AndRhombus) epk.getList().get(i)).getId((AND) ((AndRhombus) epk.getList().get(i)).getRefStart());
                endId = ((AndRhombus) epk.getList().get(i)).getId((AND) ((AndRhombus) epk.getList().get(i)).getRefEnd());
                System.out.println(id +  "[label=\"AND\", shape = circle];");
                System.out.println(endId + " [label=\"AND\", shape = circle];");
            } else if (epk.getList().get(i) instanceof Loop) {
                id = ((Loop) epk.getList().get(i)).getId((OR) ((Loop) epk.getList().get(i)).getRefStart());
                endId = ((Loop) epk.getList().get(i)).getId((XOR) ((Loop) epk.getList().get(i)).getRefEnd());
                System.out.println(id + "  [label=\"OR\", shape = circle];");
                System.out.println((endId) + " [label=\"XOR\", shape = circle];");
            }
            i++;
        }
        System.out.println("}");
    }
}