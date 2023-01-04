import java.util.*;
import java.util.List;

public class insertText {
    public insertText(EPK_new epk_new) {

        List<String> infinitiv = getInfinitiv();
        List<String> partizip = getPartizip();
        List<String> substantiv = getSubstantiv();
        List<Object> list = epk_new.getList();
        List<Kante> kantenList = epk_new.getKantenList();
        setList(list);

        Random rnd = new Random();
        int rndWort;

        int i=0;
        while(i < list.size()){
            if(list.get(i) instanceof RhombusOrLoop){
                //suche nach der Kante mit dem Start Rhoops als Startreferenz
                for(int j = 0; j < list.size(); j++){
                    if(list.get(j) instanceof Kante
                            && ((Kante) list.get(j)).getRefStart().equals(((RhombusOrLoop) list.get(i)).getRefStart())){
                        int position = 0;
                        int kantenIndex = j;
                        int substantivWort = rnd.nextInt(substantiv.size());
                        setRndWort(rnd.nextInt(infinitiv.size()));
                        //solange das Gate Ende nicht erreicht wurde, wird befüllt und nach weiteren Kanten & Elementen gesucht
                        while(!(((Kante) list.get(kantenIndex)).getRefEnd() instanceof Gate)) {
                            kantenIndex = fillText(kantenIndex);
                            setPosition(position++);
                        }

                    }
                }
            }
            i++;
        }
        for(int p = 0; p < 10; p++) {
            fillAfterEndgate();
            fillTheRest();
        }
    }

    public void fillAfterEndgate(){
        List<String> infinitiv = getInfinitiv();
        List<String> partizip = getPartizip();
        List<String> substantiv = getSubstantiv();
        List<Object> list = getList();
        List<Kante> kantenList = getKantenList();

        Random rnd = new Random();
        int rndWort;
        boolean lastElement = false;
        int kantenIndex = 0;

        int i=0;
        while(i < list.size() && !lastElement){
            if(list.get(i) instanceof RhombusOrLoop){
                //suche nach der Kante mit dem Start Rhoops als Startreferenz
                for(int j = 0; j < list.size(); j++){
                    if(list.get(j) instanceof Kante
                            && ((Kante) list.get(j)).getRefStart().equals(((RhombusOrLoop) list.get(i)).getRefEnd())){
                        int position = 0;
                        kantenIndex = j;
                        int substantivWort = rnd.nextInt(substantiv.size());
                        setRndWort(rnd.nextInt(infinitiv.size()));
                        //solange das Gate Ende nicht erreicht wurde, wird befüllt und nach weiteren Kanten & Elementen gesucht
                        while(!(((Kante) list.get(kantenIndex)).getRefEnd() instanceof Gate)) {
                            kantenIndex = fillText(kantenIndex);
                            setPosition(position++);
                            if(((Kante) list.get(kantenIndex)).getRefEnd() instanceof Event
                                    && ((Event) ((Kante) list.get(kantenIndex)).getRefEnd()).getId() == 2){
                                lastElement = true;
                                break;
                            }
                        }

                    }

                    if(list.get(kantenIndex) instanceof Kante
                            && (((Kante) list.get(kantenIndex)).getRefEnd()) instanceof Event
                            && (((Event) ((Kante) list.get(kantenIndex)).getRefEnd()).getId()==2)){
                        lastElement = true;
                        break;
                    }
                }
            }
            i++;
        }
        //fillTheRest();
    }

    public void fillTheRest(){
        List<String> infinitiv = getInfinitiv();
        List<String> partizip = getPartizip();
        List<String> substantiv = getSubstantiv();
        List<Object> list = getList();
        List<Kante> kantenList = getKantenList();

        Random rnd = new Random();
        int rndWort;
        boolean lastElement = false;
        int kantenIndex = 0;

        int i=0;
        while(i < list.size() && !lastElement){
            if(list.get(i) instanceof Kante){
                //suche nach der Kante mit dem Start Rhoops als Startreferenz
                for(int j = 0; j < list.size(); j++){
                    if(list.get(j) instanceof Kante){
                        int position = 0;
                        kantenIndex = j;
                        int substantivWort = rnd.nextInt(substantiv.size());
                        setRndWort(rnd.nextInt(infinitiv.size()));
                        //solange das Gate Ende nicht erreicht wurde, wird befüllt und nach weiteren Kanten & Elementen gesucht
                        while(!(((Kante) list.get(kantenIndex)).getRefEnd() instanceof Gate)) {
                            kantenIndex = fillText(kantenIndex);
                            setPosition(position++);
                            if(((Kante) list.get(kantenIndex)).getRefEnd() instanceof Event
                                    && ((Event) ((Kante) list.get(kantenIndex)).getRefEnd()).getId() == 2){
                                lastElement = true;
                                break;
                            }
                        }

                    }

                    if(list.get(kantenIndex) instanceof Kante
                            && (((Kante) list.get(kantenIndex)).getRefEnd()) instanceof Event
                            && (((Event) ((Kante) list.get(kantenIndex)).getRefEnd()).getId()==2)){
                        lastElement = true;
                        break;
                    }
                }
            }
            i++;
        }
    }

    public int fillText(int kantenIndex){
        List<String> infinitiv = getInfinitiv();
        List<String> partizip = getPartizip();
        List<String> substantiv = getSubstantiv();
        List<Object> list = getList();
        List<Kante> kantenList = getKantenList();

        Random rnd = new Random();

        if (((Kante) list.get(kantenIndex)).getRefEnd() instanceof Event
                && ((Event) ((Kante) list.get(kantenIndex)).getRefEnd()).getPosition() == null) {
            //befüllen der Startreferenz, wenn nicht schon getan (da es ggf vorher eine Endrefernz war)
            if(((Kante) list.get(kantenIndex)).getRefStart() instanceof Function
                    && ((Function) ((Kante) list.get(kantenIndex)).getRefStart()).getPosition() == null){
                ((Function) ((Kante) list.get(kantenIndex)).getRefStart()).setText(substantiv.get(substantivWort) + " " + infinitiv.get(rndWort));
                ((Function) ((Kante) list.get(kantenIndex)).getRefStart()).setPosition(position);
                setPosition(position++);
                try{infinitiv.remove(rndWort);}catch(Exception e){}
                //Nach dem Event muss ein neues Partizip/Infinitiv Verbpaar gezogen werden
                rndWort = rnd.nextInt(infinitiv.size());
            }
            ((Event) ((Kante) list.get(kantenIndex)).getRefEnd()).setText(substantiv.get(substantivWort) + " " + partizip.get(rndWort));
            ((Event) ((Kante) list.get(kantenIndex)).getRefEnd()).setPosition(position);
            try{partizip.remove(rndWort);}catch(Exception e){}
        }

        else if (((Kante) list.get(kantenIndex)).getRefEnd() instanceof Function
                && ((Function) ((Kante) list.get(kantenIndex)).getRefEnd()).getPosition() == null) {
            if(((Kante) list.get(kantenIndex)).getRefStart() instanceof Event
                    && ((Event) ((Kante) list.get(kantenIndex)).getRefStart()).getPosition() == null){
                ((Event) ((Kante) list.get(kantenIndex)).getRefStart()).setText(substantiv.get(substantivWort) + " " + partizip.get(rndWort));
                ((Event) ((Kante) list.get(kantenIndex)).getRefStart()).setPosition(position);
                position++;
                try{partizip.remove(rndWort);}catch(Exception e){}
            }
            ((Function) ((Kante) list.get(kantenIndex)).getRefEnd()).setText(substantiv.get(substantivWort) + " " + infinitiv.get(rndWort));
            ((Function) ((Kante) list.get(kantenIndex)).getRefEnd()).setPosition(position);
            try{infinitiv.remove(rndWort);}catch(Exception e){}
        }

        //finden der nächsten Kante und setzen des kantenindexes darauf
        for(int k = 0; k < list.size(); k++){
            if(list.get(k) instanceof Kante
                    && ((Kante) list.get(k)).getRefStart().equals(((Kante) list.get(kantenIndex)).getRefEnd())){
                kantenIndex = k;
                if (((Kante) list.get(kantenIndex)).getRefEnd() instanceof Gate) {
                    try{substantiv.remove(substantivWort);}catch(Exception e){}
                }
                break;
            }
        }
        return kantenIndex;
    }

    private List<String> infinitiv = new ArrayList<>(Arrays.asList("rennen", "schreien", "wachsen", "spielen", "fahren", "lesen", "essen", "bauen", "stehen", "traben", "arbeiten", "schwimmen", "bl\u00fchen", "gackern", "kriechen", "scheinen", "fallen", "rieseln", "rauschen", "flie\u00dfen", "lernen", "unterrichten", "verhaften", "l\u00f6schen", "heilen", "pflegen", "backen", "kochen", "schlachten", "tanzen", "singen", "malen", "schreiben", "fliegen", "bedienen", "bauen", "planen", "verhandeln", "kaufen", "reparieren", "k\u00fcmmern", "stricken", "schnitzen", "treffen", "plaudern", "lieben", "pflegen", "besuchen", "raten", "scherzen", "reden", "laufen", "schlafen", "tragen", "werfen", "springen", "brechen", "schlagen", "bewegen", "trinken", "riechen", "schmecken", "f\u00fchlen", "h\u00f6ren", "sehen", "wissen", "denken", "f\u00fchlen", "empfinden", "sprechen", "reden", "antworten", "fragen", "forschen", "entdecken", "erforschen", "l\u00f6sen", "analysieren", "interpretieren", "rechnen", "l\u00f6sen", "entscheiden", "beurteilen", "bewerten", "kategorisieren", "vergleichen", "abw\u00e4gen", "bewundern", "begeistern", "bekommen", "beziehen", "besitzen", "empfangen", "erhalten", "verdienen", "gewinnen", "bezahlen"));
    private List<String> partizip = new ArrayList<>(Arrays.asList("hat gerannt", "hat geschrien", "hat gewachsen", "hat gespielt", "hat gefahren", "hat gelesen", "hat gegessen", "hat gebaut", "hat gestanden", "hat getrabt", "hat gearbeitet", "hat geschwommen", "hat gebl\u00fcht", "hat gegackert", "hat gekrochen", "hat gescheinen", "hat gefallen", "hat gerieseln", "hat gerauscht", "hat geflossen", "hat gelernt", "hat unterrichtet", "hat verhaftet", "hat gel\u00f6scht", "hat geheilt", "hat gepflegt", "hat gebacken", "hat gekocht", "hat geschlachtet", "hat getanzt", "hat gesungen", "hat gemalt", "hat geschrieben", "hat geflogen", "hat bedient", "hat gebaut", "hat geplant", "hat verhandelt", "hat gekauft", "hat repariert", "hat gek\u00fcmmert", "hat gestrickt", "hat geschnitzt", "hat getroffen", "hat geplaudert", "hat geliebt", "hat gepflegt", "hat besucht", "hat geraten", "hat gescherzt", "hat geredet", "hat gelaufen", "hat geschlafen", "hat getragen", "hat geworfen", "hat gesprungen", "hat gebrochen", "hat geschlagen", "hat bewegt", "hat getrunken", "hat gerochen", "hat geschmeckt", "hat gef\u00fchlt", "hat geh\u00f6rt", "hat gesehen", "hat gewusst", "hat gedacht", "hat gef\u00fchlt", "hat empfunden", "hat gesprochen", "hat geredet", "hat beantwortet", "hat gefragt", "hat forschungen", "hat entdeckt", "hat erforscht","hat gel\u00f6st", "hat analysiert", "hat interpretiert", "hat gerechnet", "hat gel\u00f6st", "hat entschieden", "hat beurteilt", "hat bewertet", "hat kategoriert", "hat verglichen", "hat abgewogen", "hat bewundert", "hat begeistert", "hat bekommen", "hat bezogen", "hat besessen", "hat empfangen", "hat erhalten", "hat verdient", "hat gewonnen", "hat bezahlt"));
    private List<String> substantiv = new ArrayList<>(Arrays.asList("Hund", "Frau", "Baum", "Kind", "Auto", "Buch", "Apfel", "Haus", "Tisch", "Pferd", "Mann", "See", "K\u00e4tzchen", "Vogel", "Fisch", "Blume", "H\u00fchner", "Schmetterling", "K\u00e4fer", "Stuhl", "Sonne", "Regen", "Schnee", "Sand", "Meer", "Fluss", "Wasser", "Berg", "Sch\u00fcler", "Lehrer", "Polizist", "Feuerwehrmann", "Arzt", "Krankenschwester", "B\u00e4cker", "K\u00f6chin", "Metzger", "T\u00e4nzer", "S\u00e4nger", "Schauspieler", "Musiker", "K\u00fcnstler", "Schriftsteller", "Journalist", "Pilot", "Flugbegleiter", "Fahrer", "Ingenieur", "Architekt", "Jurist", "Banker", "Verk\u00e4ufer", "Kunde", "Mutter", "Vater", "Schwester", "Bruder", "Gro\u00dfmutter", "Gro\u00dfvater", "Freund", "Freundin", "Ehemann", "Ehefrau", "Enkel", "Enkelin", "Timm", "Schwiegermutter", "Schwager", "Schw\u00e4gerin", "Neffe", "Nichte", "Onkel", "Tante", "Cousin", "Cousine", "Br\u00e4utigam", "Braut", "Junge", "M\u00e4dchen", "Bub", "Angela Merkel", "Helmut Schmidt", "J\u00fcrgen Klopp", "Mario G\u00f6tze", "J\u00fcrgen Klinsmann", "Bastian Schweinsteiger", "Professor Munkelt", "Manuel Neuer", "Boris Becker", "Steffi Graf", "Katja Ebstein", "Udo Lindenberg", "Till Lindermann", "Kraftklub", "Jan B\u00f6hmermann", "Joko Winterscheidt", "Bernd das Brot", "Caroline Kebekus", "Klaas Heufer-Umlauf", "Helene Fischer"));
    private List<Object> list;
    private List<Kante> kantenList;
    private EPK_new epk_new;
    private int position;
    private int rndWort;
    private int substantivWort;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getRndWort() {
        return rndWort;
    }

    public void setRndWort(int rndWort) {
        this.rndWort = rndWort;
    }

    public int getSubstantivWort() {
        return substantivWort;
    }

    public void setSubstantivWort(int substantivWort) {
        this.substantivWort = substantivWort;
    }

    public List<String> getInfinitiv() {
        return infinitiv;
    }

    public void setInfinitiv(List<String> infinitiv) {
        this.infinitiv = infinitiv;
    }

    public List<String> getPartizip() {
        return partizip;
    }

    public void setPartizip(List<String> partizip) {
        this.partizip = partizip;
    }

    public List<String> getSubstantiv() {
        return substantiv;
    }

    public void setSubstantiv(List<String> substantiv) {
        this.substantiv = substantiv;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public List<Kante> getKantenList() {
        return kantenList;
    }

    public void setKantenList(List<Kante> kantenList) {
        this.kantenList = kantenList;
    }

    public EPK_new getEpk_new() {
        return epk_new;
    }

    public void setEpk_new(EPK_new epk_new) {
        this.epk_new = epk_new;
    }
}
