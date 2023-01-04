public class ProjSem {

    public static void main(String[] args) {
        //Aufruf mit einem integer (Wert ist aktuell egal) wird eine Testeinstellung angewendet
        Parameters parameters = new Parameters(2);
        //Ohne Parameter darf der Nutzer diese eingeben
        //Parameters parameters = new Parameters();
        EPK_new epk_new = new EPK_new(parameters);

        insertText insertText = new insertText(epk_new);

        Edotor edotor = new Edotor();
        edotor.generateEdotor(epk_new);

    }
}