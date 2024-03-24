import java.util.Objects;

public class Karta {

    public enum Kolor {
        Trefl, Karo, Kier, Pik;
    }
    public enum TypKarty{
        Dwa, Trzy, Cztery, Piec, Szesc, Siedem, Osiem, Dziewiec, Dziesiec, Walet, Dama, Krol, As;
    }
    private Kolor kolor;
    private TypKarty typ;

    public Karta(Kolor kolor_, TypKarty typ_){
        kolor = kolor_;
        typ = typ_;
    }

    public String toString(){
        return "[" + kolor + ", " + typ + "]";
    }

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
