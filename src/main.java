public class main {

    public static void main(String[] args) {
        Parameters parameters = new Parameters(2);
        //Parameters parameters = new Parameters();
        EPK_new epk_new = new EPK_new(parameters);

        insertText insertText = new insertText(epk_new);

        Mermaid mermaid = new Mermaid();
        mermaid.generateMermaid(epk_new);


    }
}