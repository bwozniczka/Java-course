import java.util.ArrayList;

public class Gracz {
    private ArrayList<Karta> reka;

    public Gracz(){
        reka = new ArrayList<>();
    }
    public ArrayList<Karta>getGracz(){
        return reka;
    }
    public void dodajKarte(Karta karta_){
        this.reka.add(karta_);
    }
    public ArrayList<Karta> getKarta(){
        return this.reka;
    }

}
