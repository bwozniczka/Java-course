import java.util.Objects;

/**
 * Klasa reprezętująca wszystkie 52 karty
 */
public class Karta {

    public enum Kolor {
        Trefl, Karo, Kier, Pik;
    }
    public enum TypKarty{
        Dwa, Trzy, Cztery, Piec, Szesc, Siedem, Osiem, Dziewiec, Dziesiec, Walet, Dama, Krol, As;
    }
    public Kolor kolor;
    public TypKarty typ;

    /**
     *
     * @param kolor_ zmienna reprezentujaca kolor karty
     * @param typ_ zmien reprezentujaca typ karty
     */
    public Karta(Kolor kolor_, TypKarty typ_){
        kolor = kolor_;
        typ = typ_;
    }

    /**
     * metoda pozwalajca na wyswietlenie karty
     * @return
     */
    public String toString(){
        return "[" + kolor + ", " + typ + "]";
    }

    /**
     * metoda sprawdza czy obiekty sa rowne
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Karta card = (Karta) o;
        return kolor == card.kolor && typ == card.typ;
    }

    /**
     * @return rrrtt
     */
    @Override
    public int hashCode() {
        return Objects.hash(kolor, typ);
    }
}
