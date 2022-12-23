public class mainProg {

    public static void main(String[] args) {
        Parameters parameters = new Parameters();
        parameters.setLoops();
        parameters.setRhomben();;

        EPK_new epk_new = new EPK_new(parameters);

        Mermaid mermaid = new Mermaid();
        mermaid.generateMermaid(epk_new);

    }
}