import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Klasa ktora reprezentuje talie 52 kart
 */
public class Talia {
    private ArrayList<Karta> talia;

    public Talia(){
        talia = new ArrayList<>();
    }

    /**
     * meotda zwraca talie swtorzona z 52 kart, talie nie jest pomieszana
     * @return
     */
    public static Talia stworzNowaTalie(){
        Talia nowaTalia = new Talia();
        for(Karta.Kolor kolor : Karta.Kolor.values()) {
            for(Karta.TypKarty typ : Karta.TypKarty.values()){
                nowaTalia.talia.add(new Karta(kolor, typ));
            }
        }
        return nowaTalia;
    }

    public ArrayList<Karta> getTalia(){
        return talia;
    }

    /**
     * metoda ktora tasuje talie
     */
    public void potasuj(){
        Collections.shuffle(talia);
    }

    /**
     * metoda ktora wyciaga jedna karte z talii , gdy ilosc kart w tali jest owna 0 rzuca wyjatek "NoCardException"
     * @return
     * @throws NoCardException
     */
    public Karta PociagnijKarte() throws NoCardException {
        if(talia.isEmpty()){
            throw new NoCardException();
        }
        return talia.remove(0);
    }

    /**
     * meotda sluzy do wyswietlenia calej talii
     */
    public void wyswietlKarty() {
        ArrayList<Karta> karty = getTalia();
        for (Karta karta : karty) {
            System.out.println(karta);
        }
    }

    public static void main(String[] args) {
        Talia nowaTalia = Talia.stworzNowaTalie();
        nowaTalia.wyswietlKarty();
        System.out.println("-------------------------------");
        Talia pomieszanaTalia = Talia.stworzNowaTalie();
        pomieszanaTalia.potasuj();;
        pomieszanaTalia.wyswietlKarty();
        System.out.println("--------------------------------");
        for(int i = 0; i < 53; i++) {
            try {
                System.out.println(pomieszanaTalia.PociagnijKarte());
            } catch (NoCardException e) {
                System.out.println("Brak dostępnych kart w talii.");
            }
        }
    }

}
