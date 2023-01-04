import java.util.*;
import java.util.List;

public class insertText {
    public insertText(EPK_new epk_new) {
        List<String> infinitiv = new ArrayList<>(Arrays.asList("rennen", "schreien", "wachsen", "spielen", "fahren", "lesen", "essen", "bauen", "stehen", "traben", "arbeiten", "schwimmen", "bl\u00fchen", "gackern", "kriechen", "scheinen", "fallen", "rieseln", "rauschen", "flie\u00dfen", "lernen", "unterrichten", "verhaften", "l\u00f6schen", "heilen", "pflegen", "backen", "kochen", "schlachten", "tanzen", "singen", "malen", "schreiben", "fliegen", "bedienen", "bauen", "planen", "verhandeln", "kaufen", "reparieren", "k\u00fcmmern", "stricken", "schnitzen", "treffen", "plaudern", "lieben", "pflegen", "besuchen", "raten", "scherzen", "reden", "laufen", "schlafen", "tragen", "werfen", "springen", "brechen", "schlagen", "bewegen", "trinken", "riechen", "schmecken", "f\u00fchlen", "h\u00f6ren", "sehen", "wissen", "denken", "f\u00fchlen", "empfinden", "sprechen", "reden", "antworten", "fragen", "forschen", "entdecken", "erforschen", "l\u00f6sen", "analysieren", "interpretieren", "rechnen", "l\u00f6sen", "entscheiden", "beurteilen", "bewerten", "kategorisieren", "vergleichen", "abw\u00e4gen", "bewundern", "begeistern", "bekommen", "beziehen", "besitzen", "empfangen", "erhalten", "verdienen", "gewinnen", "bezahlen"));
        List<String> partizip = new ArrayList<>(Arrays.asList("hat gerannt", "hat geschrien", "hat gewachsen", "hat gespielt", "hat gefahren", "hat gelesen", "hat gegessen", "hat gebaut", "hat gestanden", "hat getrabt", "hat gearbeitet", "hat geschwommen", "hat gebl\u00fcht", "hat gegackert", "hat gekrochen", "hat gescheinen", "hat gefallen", "hat gerieseln", "hat gerauscht", "hat geflossen", "hat gelernt", "hat unterrichtet", "hat verhaftet", "hat gel\u00f6scht", "hat geheilt", "hat gepflegt", "hat gebacken", "hat gekocht", "hat geschlachtet", "hat getanzt", "hat gesungen", "hat gemalt", "hat geschrieben", "hat geflogen", "hat bedient", "hat gebaut", "hat geplant", "hat verhandelt", "hat gekauft", "hat repariert", "hat gek\u00fcmmert", "hat gestrickt", "hat geschnitzt", "hat getroffen", "hat geplaudert", "hat geliebt", "hat gepflegt", "hat besucht", "hat geraten", "hat gescherzt", "hat geredet", "hat gelaufen", "hat geschlafen", "hat getragen", "hat geworfen", "hat gesprungen", "hat gebrochen", "hat geschlagen", "hat bewegt", "hat getrunken", "hat gerochen", "hat geschmeckt", "hat gef\u00fchlt", "hat geh\u00f6rt", "hat gesehen", "hat gewusst", "hat gedacht", "hat gef\u00fchlt", "hat empfunden", "hat gesprochen", "hat geredet", "hat beantwortet", "hat gefragt", "hat forschungen", "hat entdeckt", "hat erforscht","hat gel\u00f6st", "hat analysiert", "hat interpretiert", "hat gerechnet", "hat gel\u00f6st", "hat entschieden", "hat beurteilt", "hat bewertet", "hat kategoriert", "hat verglichen", "hat abgewogen", "hat bewundert", "hat begeistert", "hat bekommen", "hat bezogen", "hat besessen", "hat empfangen", "hat erhalten", "hat verdient", "hat gewonnen", "hat bezahlt"));
        List<String> substantiv = new ArrayList<>(Arrays.asList("Hund", "Frau", "Baum", "Kind", "Auto", "Buch", "Apfel", "Haus", "Tisch", "Pferd", "Mann", "See", "K\u00e4tzchen", "Vogel", "Fisch", "Blume", "H\u00fchner", "Schmetterling", "K\u00e4fer", "Stuhl", "Sonne", "Regen", "Schnee", "Sand", "Meer", "Fluss", "Wasser", "Berg", "Sch\u00fcler", "Lehrer", "Polizist", "Feuerwehrmann", "Arzt", "Krankenschwester", "B\u00e4cker", "K\u00f6chin", "Metzger", "T\u00e4nzer", "S\u00e4nger", "Schauspieler", "Musiker", "K\u00fcnstler", "Schriftsteller", "Journalist", "Pilot", "Flugbegleiter", "Fahrer", "Ingenieur", "Architekt", "Jurist", "Banker", "Verk\u00e4ufer", "Kunde", "Mutter", "Vater", "Schwester", "Bruder", "Gro\u00dfmutter", "Gro\u00dfvater", "Freund", "Freundin", "Ehemann", "Ehefrau", "Enkel", "Enkelin", "Timm", "Schwiegermutter", "Schwager", "Schw\u00e4gerin", "Neffe", "Nichte", "Onkel", "Tante", "Cousin", "Cousine", "Br\u00e4utigam", "Braut", "Junge", "M\u00e4dchen", "Bub", "Angela Merkel", "Helmut Schmidt", "J\u00fcrgen Klopp", "Mario G\u00f6tze", "J\u00fcrgen Klinsmann", "Bastian Schweinsteiger", "Professor Munkelt", "Manuel Neuer", "Boris Becker", "Steffi Graf", "Katja Ebstein", "Udo Lindenberg", "Till Lindermann", "Kraftklub", "Jan B\u00f6hmermann", "Joko Winterscheidt", "Bernd das Brot", "Caroline Kebekus", "Klaas Heufer-Umlauf", "Helene Fischer"));
        List<Object> list = epk_new.getList();
        List<Kante> kantenList = epk_new.getKantenList();


//       Collections.replaceAll(infinitiv, "\u00e4", "\u00e4");
//        Collections.replaceAll(infinitiv, "\u00f6", "\u00f6");
//        Collections.replaceAll(infinitiv, "\u00fc", "\u00fc");
//        Collections.replaceAll(infinitiv, "\u00df", "\u00df");
//        Collections.replaceAll(partizip, "\u00e4", "\u00e4");
//        Collections.replaceAll(partizip, "\u00f6", "\u00f6");
//        Collections.replaceAll(partizip, "\u00fc", "\u00fc");
//        Collections.replaceAll(partizip, "\u00df", "\u00df");
//        Collections.replaceAll(substantiv, "\u00e4", "\u00e4");
//        Collections.replaceAll(substantiv, "\u00f6", "\u00f6");
//        Collections.replaceAll(substantiv, "\u00fc", "\u00fc");
//        Collections.replaceAll(substantiv, "\u00df", "\u00df");


        Random rnd = new Random();
        int i = 0;
//        System.out.println("\u00e4 infi: " + infinitiv.size());
//        System.out.println("\u00e4 parti: " + partizip.size());
//        System.out.println("\u00e4 subsi: " + substantiv.size());


        int rndWort;
        //solange kein Gate erreicht wurde, nehme das gleiche Substantiv. Wenn das Element vor dem Gate eine Funktion ist
        //muss sich das Event dahinter darauf beziehen
//        while(i < kantenList.size()){
//
//            if(kantenList.get(i).getRefStart() instanceof Event || kantenList.get(i).getRefStart() instanceof Function) {
//                rndWort = rnd.nextInt(infinitiv.size());
//                if (kantenList.get(i).getRefStart() instanceof Event) {
//                    ((Event) kantenList.get(i).getRefStart()).setText(substantiv.get(rndWort) + " " + partizip.get(rndWort));
//                } else if (kantenList.get(i).getRefStart() instanceof Function) {
//                    ((Function) kantenList.get(i).getRefStart()).setText(substantiv.get(rndWort) + " " + infinitiv.get(rndWort));
//                }
//                try {
//                    infinitiv.remove(rndWort);
//                    partizip.remove(rndWort);
//                    substantiv.remove(rndWort);
//                }catch(Exception e){}
//            }
//            i++;
//        }

        i=0;
        while(i < list.size()){
            if(list.get(i) instanceof RhombusOrLoop){
                //suche nach der Kante mit dem Start Rhoops als Startreferenz
                for(int j = 0; j < list.size(); j++){
                    if(list.get(j) instanceof Kante
                            && ((Kante) list.get(j)).getRefStart().equals(((RhombusOrLoop) list.get(i)).getRefStart())){
                        int position = 0;
                        int kantenIndex = j;
                        int substantivWort = rnd.nextInt(substantiv.size());
                        //solange das Gate Ende nicht erreicht wurde, wird befüllt und nach weiteren Kanten & Elementen gesucht
                        while(((Kante) list.get(kantenIndex)).getRefEnd() instanceof Gate) {
                            rndWort = rnd.nextInt(infinitiv.size());

                            if (((Kante) list.get(kantenIndex)).getRefEnd() instanceof Event) {
                                //befüllen der Startreferenz, wenn nicht schon getan (da es ggf vorher eine Endrefernz war)
                                if(((Kante) list.get(kantenIndex)).getRefStart() instanceof Function
                                        && ((Function) ((Kante) list.get(kantenIndex)).getRefStart()).getPosition() != null){
                                    ((Function) ((Kante) list.get(kantenIndex)).getRefStart()).setText(substantiv.get(substantivWort) + " " + infinitiv.get(rndWort));
                                    ((Function) ((Kante) list.get(kantenIndex)).getRefStart()).setPosition(position);
                                    position++;
                                    try{infinitiv.remove(rndWort);}catch(Exception e){}
                                }
                                ((Event) ((Kante) list.get(kantenIndex)).getRefEnd()).setText(substantiv.get(substantivWort) + " " + partizip.get(rndWort));
                                ((Event) ((Kante) list.get(kantenIndex)).getRefEnd()).setPosition(position);
                                try{partizip.remove(rndWort);}catch(Exception e){}
                            }

                            else if (((Kante) list.get(kantenIndex)).getRefEnd() instanceof Function) {
                                if(((Kante) list.get(kantenIndex)).getRefStart() instanceof Event
                                        && ((Event) ((Kante) list.get(kantenIndex)).getRefStart()).getPosition() != null){
                                    ((Event) ((Kante) list.get(kantenIndex)).getRefStart()).setText(substantiv.get(substantivWort) + " " + partizip.get(rndWort));
                                    ((Event) ((Kante) list.get(kantenIndex)).getRefStart()).setPosition(position);
                                    position++;
                                    try{partizip.remove(rndWort);}catch(Exception e){}
                                }
                                ((Function) ((Kante) list.get(kantenIndex)).getRefEnd()).setText(substantiv.get(substantivWort) + " " + infinitiv.get(rndWort));
                                ((Function) ((Kante) list.get(kantenIndex)).getRefEnd()).setPosition(position);
                                try{infinitiv.remove(rndWort);}catch(Exception e){}
                            } else if (((Kante) list.get(kantenIndex)).getRefEnd() instanceof Gate) {}

                            //finden der nächsten Kante und setzen des kantenindexes darauf
                            for(int k = 0; k < list.size(); k++){
                                if(list.get(k) instanceof Kante
                                        && ((Kante) list.get(k)).getRefStart().equals(((Kante) list.get(kantenIndex)).getRefEnd())){
                                    kantenIndex = k;
                                }
                            }
                            position++;
                        }
                        try{substantiv.remove(substantivWort);}catch(Exception e){}
                    }
                }
            }
            i++;
        }
    }
}
