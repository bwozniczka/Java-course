public class Karta {
    public enum Kolor {
        Trefl, Karo, Kier, Pik;
    }

    public enum TypKarty{
        Dwa, Trzy, Cztery, Piec, Szesc, Siedem, Osiem, Dziewiec, Dziesiec, Walet, Dama, Krol, As;
    }

    private final Kolor kolor;
    private final TypKarty typ;

    public Karta(Kolor kolor_, TypKarty typ_){
        kolor = kolor_;
        typ = typ_;
    }

    public String toString() {
        return "[" + kolor + ", " + typ + "]";
    }

}


