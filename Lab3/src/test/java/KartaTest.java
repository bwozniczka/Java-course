import static org.junit.jupiter.api.Assertions.*;

public class KartaTest {

    @org.junit.Test
    public void testToString() {
        Karta karta = new Karta(Karta.Kolor.Karo, Karta.TypKarty.As);
        String expected = "[Karo, As]";
        String result = karta.toString();
        assertEquals(expected, result);
    }

    @org.junit.Test
    public void testEquals() {
        Karta karta1 = new Karta(Karta.Kolor.Trefl, Karta.TypKarty.Dwa);
        Karta karta2 = new Karta(Karta.Kolor.Trefl, Karta.TypKarty.Dwa);
        Karta karta3 = new Karta(Karta.Kolor.Karo, Karta.TypKarty.Dwa);
        Karta karta4 = new Karta(Karta.Kolor.Pik, Karta.TypKarty.Cztery);

        assertTrue(karta1.equals(karta2));
        assertFalse(karta1.equals(karta3));
        assertFalse(karta1.equals(karta4));
    }

    @org.junit.Test
    public void testHashCode() {
        Karta karta1 = new Karta(Karta.Kolor.Trefl, Karta.TypKarty.Dwa);
        Karta karta2 = new Karta(Karta.Kolor.Trefl, Karta.TypKarty.Dwa);
        Karta karta3 = new Karta(Karta.Kolor.Karo, Karta.TypKarty.Dwa);

        assertEquals(karta1.hashCode(), karta2.hashCode());
        assertNotEquals(karta1.hashCode(), karta3.hashCode());
    }
}