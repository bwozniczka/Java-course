import java.util.ArrayList;
import java.util.Collections;

public class Talia {
    private ArrayList<Karta> talia;

    private Talia() {
        talia = new ArrayList<>();
    }

    public static Talia stworzNowaTalie() {
        Talia nowaTalia = new Talia();
        for (Karta.Kolor kolor : Karta.Kolor.values()) {
            for (Karta.TypKarty typ : Karta.TypKarty.values()) {
                nowaTalia.talia.add(new Karta(kolor, typ));
            }
        }
        return nowaTalia;
    }

    public ArrayList<Karta> getKarty() {
        return talia;
    }
    public void wyswietlKarty() {
        ArrayList<Karta> karty = getKarty();
        for (Karta karta : karty) {
            System.out.println(karta);
        }
    }
    public void potasuj(){
        Collections.shuffle(talia);
    }

    public Karta PociagnijKarte() throws BrakKartyException {
        if(talia.isEmpty()){
            throw new BrakKartyException();
        }
        return talia.remove(0);
    }

    public ArrayList<Karta> getTalia(){
        return talia;
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
            } catch (BrakKartyException e) {
                System.out.println("Brak dostępnych kart w talii.");
            }
        }
    }
}



