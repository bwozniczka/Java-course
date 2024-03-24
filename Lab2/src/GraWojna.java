import java.util.ArrayList;

public class GraWojna extends Gra {

    public GraWojna() throws NoCardException {
        Rozdanie();
    }

    public void Rozdanie() throws NoCardException {
        Talia TaliaDoGry = Talia.stworzNowaTalie();
        TaliaDoGry.potasuj();
        this.gracze.add(new Gracz());
        this.gracze.add(new Gracz());
        while(!TaliaDoGry.getTalia().isEmpty()){
            this.gracze.get(0).dodajKarte(TaliaDoGry.PociagnijKarte());
            this.gracze.get(1).dodajKarte(TaliaDoGry.PociagnijKarte());
        }
        System.out.println("Gracz 1");
        System.out.println(this.gracze.get(0).getKarta());
        System.out.println("Gracz 2");
        System.out.println(this.gracze.get(1).getKarta());

    }

    public static void main(String[] args) throws NoCardException {
        GraWojna wojna = new GraWojna();

    }
}
