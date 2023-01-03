import java.util.*;
import java.util.List;

public class insertText {
    public insertText(EPK_new epk_new) {
        List<String> infinitiv = new ArrayList<>(Arrays.asList("rennen", "schreien", "wachsen", "spielen", "fahren", "lesen", "essen", "bauen", "stehen", "traben", "arbeiten", "schwimmen", "blühen", "gackern", "kriechen", "scheinen", "fallen", "rieseln", "rauschen", "fließen", "lernen", "unterrichten", "verhaften", "löschen", "heilen", "pflegen", "backen", "kochen", "schlachten", "tanzen", "singen", "malen", "schreiben", "fliegen", "bedienen", "bauen", "planen", "verhandeln", "kaufen", "reparieren", "kümmern", "stricken", "schnitzen", "treffen", "plaudern", "lieben", "pflegen", "besuchen", "raten", "scherzen", "reden", "laufen", "schlafen", "tragen", "werfen", "springen", "brechen", "schlagen", "bewegen", "trinken", "riechen", "schmecken", "fühlen", "hören", "sehen", "wissen", "denken", "fühlen", "empfinden", "sprechen", "reden", "antworten", "fragen", "forschen", "entdecken", "erforschen", "lösen", "analysieren", "interpretieren", "rechnen", "lösen", "entscheiden", "beurteilen", "bewerten", "kategorisieren", "vergleichen", "abw\\u00e4gen", "bewundern", "begeistern", "bekommen", "beziehen", "besitzen", "empfangen", "erhalten", "verdienen", "gewinnen", "bezahlen"));
        List<String> partizip = new ArrayList<>(Arrays.asList("hat gerannt", "hat geschrien", "hat gewachsen", "hat gespielt", "hat gefahren", "hat gelesen", "hat gegessen", "hat gebaut", "hat gestanden", "hat getrabt", "hat gearbeitet", "hat geschwommen", "hat geblüht", "hat gegackert", "hat gekrochen", "hat gescheinen", "hat gefallen", "hat gerieseln", "hat gerauscht", "hat geflossen", "hat gelernt", "hat unterrichtet", "hat verhaftet", "hat gelöscht", "hat geheilt", "hat gepflegt", "hat gebacken", "hat gekocht", "hat geschlachtet", "hat getanzt", "hat gesungen", "hat gemalt", "hat geschrieben", "hat geflogen", "hat bedient", "hat gebaut", "hat geplant", "hat verhandelt", "hat gekauft", "hat repariert", "hat gekümmert", "hat gestrickt", "hat geschnitzt", "hat getroffen", "hat geplaudert", "hat geliebt", "hat gepflegt", "hat besucht", "hat geraten", "hat gescherzt", "hat geredet", "hat gelaufen", "hat geschlafen", "hat getragen", "hat geworfen", "hat gesprungen", "hat gebrochen", "hat geschlagen", "hat bewegt", "hat getrunken", "hat gerochen", "hat geschmeckt", "hat gefühlt", "hat gehört", "hat gesehen", "hat gewusst", "hat gedacht", "hat gefühlt", "hat empfunden", "hat gesprochen", "hat geredet", "hat beantwortet", "hat gefragt", "hat forschungen", "hat entdeckt", "hat erforscht","hat gelöst", "hat analysiert", "hat interpretiert", "hat gerechnet", "hat gelöst", "hat entschieden", "hat beurteilt", "hat bewertet", "hat kategoriert", "hat verglichen", "hat abgewogen", "hat bewundert", "hat begeistert", "hat bekommen", "hat bezogen", "hat besessen", "hat empfangen", "hat erhalten", "hat verdient", "hat gewonnen", "hat bezahlt"));
        List<String> substantiv = new ArrayList<>(Arrays.asList("Hund", "Frau", "Baum", "Kind", "Auto", "Buch", "Apfel", "Haus", "Tisch", "Pferd", "Mann", "See", "K\\u00e4tzchen", "Vogel", "Fisch", "Blume", "Hühner", "Schmetterling", "K\\u00e4fer", "Stuhl", "Sonne", "Regen", "Schnee", "Sand", "Meer", "Fluss", "Wasser", "Berg", "Schüler", "Lehrer", "Polizist", "Feuerwehrmann", "Arzt", "Krankenschwester", "B\\u00e4cker", "Köchin", "Metzger", "T\\u00e4nzer", "S\\u00e4nger", "Schauspieler", "Musiker", "Künstler", "Schriftsteller", "Journalist", "Pilot", "Flugbegleiter", "Fahrer", "Ingenieur", "Architekt", "Jurist", "Banker", "Verk\\u00e4ufer", "Kunde", "Mutter", "Vater", "Schwester", "Bruder", "Großmutter", "Großvater", "Freund", "Freundin", "Ehemann", "Ehefrau", "Enkel", "Enkelin", "Schwiegervater", "Schwiegermutter", "Schwager", "Schw\\u00e4gerin", "Neffe", "Nichte", "Onkel", "Tante", "Cousin", "Cousine", "Br\\u00e4utigam", "Braut", "Junge", "M\\u00e4dchen", "Bub", "Angela Merkel", "Helmut Schmidt", "Jürgen Klopp", "Mario Götze", "Jürgen Klinsmann", "Bastian Schweinsteiger", "Thomas Muller", "Manuel Neuer", "Boris Becker", "Steffi Graf", "Katja Ebstein", "Udo Lindenberg", "Till Lindermann", "Kraftklub", "Jan Böhmermann", "Joko Winterscheidt", "Bernd das Brot", "Caroline Kebekus", "Klaas Heufer-Umlauf", "Helene Fischer"));
        List<Object> list = epk_new.getList();
        List<Kante> kantenList = epk_new.getKantenList();
        


        Random rnd = new Random();
        int i = 0;
//        System.out.println("\\u00e4 infi: " + infinitiv.size());
//        System.out.println("\u00e4 parti: " + partizip.size());
//        System.out.println("ä subsi: " + substantiv.size());



        int rndWort;
        //solange kein Gate erreicht wurde, nehme das gleiche Substantiv. Wenn das Element vor dem Gate eine Funktion ist
        //muss sich das Event dahinter darauf beziehen
        while(i < kantenList.size()){

            if(kantenList.get(i).getRefStart() instanceof Event || kantenList.get(i).getRefStart() instanceof Function) {
                rndWort = rnd.nextInt(infinitiv.size());
                if (kantenList.get(i).getRefStart() instanceof Event) {
                    ((Event) kantenList.get(i).getRefStart()).setEventText(substantiv.get(rndWort) + " " + infinitiv.get(rndWort));
                } else if (kantenList.get(i).getRefStart() instanceof Function) {
                    ((Function) kantenList.get(i).getRefStart()).setFunctionText(substantiv.get(rndWort) + " " + infinitiv.get(rndWort));
                }
                try {
                    infinitiv.remove(rndWort);
                    partizip.remove(rndWort);
                    substantiv.remove(rndWort);
                }catch(Exception e){}
            }
            i++;
        }
    }

    public void rekursiveInsertText(Kante kante, EPK_new epk_new){
        List<Object> list = epk_new.getList();
        for(int i = 0; i < list.size(); i++){

        }
    }
}
