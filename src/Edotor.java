import java.io.*;
import java.util.List;

public class Edotor {

    public void generateEdotor(EPK_new epk) {
        //Konfiguration für Ausgabe mit Umlauten
        PrintWriter out = new PrintWriter(System.out,true);
        utf8();

        //Start- und End ID der Elemente einer Kante
        Integer id, endId;
        List<Object> list = epk.getList();

        System.out.println("digraph EPK_Edotor {rankdir=TD;\nsize=\"8,5\"");

        //Schleife zum Durchlaufen der EPK Liste
        //je nach Klasse des Objects wird die Ausgabe angepasst
        int i = 0;
        while (list.size() > i)
        {
            if(list.get(i) instanceof Event)
            {
                out.println(((Event) list.get(i)).getId() +  "[label=\"" + ((Event) list.get(i)).getText() + "\", shape = hexagon];");
            }
            else if (list.get(i) instanceof Kante) {
                id = ((Kante) list.get(i)).getId((EPK_Element) ((Kante) list.get(i)).getRefStart());
                endId = ((Kante) list.get(i)).getId((EPK_Element) ((Kante) list.get(i)).getRefEnd());
                out.println(id + " -> " + endId + "[ label = \"" + ((Kante) list.get(i)).getKantenID() + "\" ]");
            }
            else if (list.get(i) instanceof Function) {
                out.println(((Function) list.get(i)).getId() + "[label=\"" + ((Function) list.get(i)).getText() + "\", shape=rectangle, style=rounded];");
            }
            else {
                id = ((RhombusOrLoop) list.get(i)).getId((Gate) ((RhombusOrLoop) list.get(i)).getRefStart());
                endId = ((RhombusOrLoop) list.get(i)).getId((Gate) ((RhombusOrLoop) list.get(i)).getRefEnd());
                if (list.get(i) instanceof OrRhombus) {
                    out.println(id + " [label=\"OR\", shape = circle];");
                    out.println((endId) + " [label=\"OR\", shape = circle];");
                } else if (list.get(i) instanceof XorRhombus) {
                    out.println(id + " [label=\"XOR\", shape = circle];");
                    out.println((endId) + " [label=\"XOR\", shape = circle];");
                } else if (list.get(i) instanceof AndRhombus) {
                    out.println(id + "[label=\"AND\", shape = circle];");
                    out.println(endId + " [label=\"AND\", shape = circle];");
                } else if (list.get(i) instanceof Loop) {
                    out.println(id + "  [label=\"OR\", shape = circle];");
                    out.println((endId) + " [label=\"XOR\", shape = circle];");
                }
            }
            i++;
        }
        out.println("}");
    }

    public void utf8(){
        try {
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new InternalError("VM does not support mandatory encoding UTF-8");
        }
    }
}