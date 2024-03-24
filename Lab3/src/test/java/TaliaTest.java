import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TaliaTest {

    @Test
    public void stworzNowaTalie() {
        Talia nowaTalia = Talia.stworzNowaTalie();

        assertFalse(nowaTalia.getTalia().isEmpty());

        int oczekiwanaIloscKart = 52;

        assertEquals(oczekiwanaIloscKart, nowaTalia.getTalia().size());

        for (Karta karta : nowaTalia.getTalia()) {
            assertNotNull(karta.kolor);
            assertNotNull(karta.typ);
        }
    }

    @Test
    public void getTalia() {
        Talia talia = new Talia();

        Karta karta1 = new Karta(Karta.Kolor.Trefl, Karta.TypKarty.Dwa);
        Karta karta2 = new Karta(Karta.Kolor.Karo, Karta.TypKarty.As);

        talia.getTalia().add(karta1);
        talia.getTalia().add(karta2);

        assertEquals(2, talia.getTalia().size());

        assertTrue(talia.getTalia().contains(karta1));
        assertTrue(talia.getTalia().contains(karta2));
    }

    @Test
    public void potasuj() {
        Talia talia = Talia.stworzNowaTalie();
        Talia taliaDoTasowania = new Talia();
        taliaDoTasowania.getTalia().addAll(talia.getTalia());
        taliaDoTasowania.potasuj();
        assertNotEquals(talia.getTalia(), taliaDoTasowania.getTalia());
    }

    @Test
    public void pociagnijKarte() throws NoCardException {
        Talia talia = Talia.stworzNowaTalie();
        Karta karta = talia.PociagnijKarte();
        assertEquals("[Trefl, Dwa]", karta.toString());
        assertEquals(51, talia.getTalia().size());
    }

    @Test
    public void wyswietlKarty() {
        Talia talia = new Talia();
        talia.getTalia().add(new Karta(Karta.Kolor.Trefl, Karta.TypKarty.Dwa));
        talia.getTalia().add(new Karta(Karta.Kolor.Karo, Karta.TypKarty.As));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        talia.wyswietlKarty();

        System.setOut(System.out);

        String expectedOutput = "[Trefl, Dwa]" + System.lineSeparator() + "[Karo, As]" + System.lineSeparator();

        assertEquals(expectedOutput, outputStream.toString());
    }

}