import java.util.ArrayList;

/**
 * Klasa reprezetuajca gracza
 */
public class Gracz {
    public ArrayList<Karta> reka;

    public Gracz(){
        reka = new ArrayList<>();
    }
//    public ArrayList<Karta>getGracz(){
//        return reka;
//    }

    /**
     * Dodaje podana karte do reki gracza
     * @param karta_
     */
    public void dodajKarte(Karta karta_){
        this.reka.add(karta_);
    }
    public ArrayList<Karta> getKarta(){
        return this.reka;
    }

}
