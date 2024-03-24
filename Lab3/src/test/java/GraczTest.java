import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GraczTest {


    @Test
    public void dodajKarte() {
        Karta karta = new Karta(Karta.Kolor.Trefl, Karta.TypKarty.Dwa);
        Karta karta1 = new Karta(Karta.Kolor.Pik, Karta.TypKarty.Walet);
        Gracz gracz = new Gracz();
        gracz.dodajKarte(karta);
        gracz.dodajKarte(karta1);
        assertEquals(2,gracz.reka.size());
        assertTrue(gracz.reka.contains(karta));
        assertTrue(gracz.reka.contains(karta1));
    }

    @Test
    public void getKarta() {
        Karta karta = new Karta(Karta.Kolor.Trefl, Karta.TypKarty.Dwa);
        Karta karta1 = new Karta(Karta.Kolor.Pik, Karta.TypKarty.Walet);
        Gracz gracz = new Gracz();
        ArrayList<Karta> reka = new ArrayList<>();
        reka.add(karta);
        reka.add(karta1);
        gracz.dodajKarte(karta);
        gracz.dodajKarte(karta1);
        assertEquals(reka,gracz.getKarta());

    }
}