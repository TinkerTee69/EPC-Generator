public class ProjSem {

    public static void main(String[] args) {
        boolean testModus = true;
        EPK epk = new EPK(new Parameters(testModus));
        insertText insertText = new insertText(epk);
        Edotor edotor = new Edotor(insertText);
    }
}