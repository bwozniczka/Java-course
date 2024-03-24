import java.util.ArrayList;
import java.util.List;

class Osoba{
    public String nazwisko;
    public int wiek;

    Osoba(String nazwisko, int wiek){
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    @Override
    public String toString() {
        return nazwisko + " " + wiek;
    }
}
public class zadanieTrzecieCzwarte {
    public static void main(String[] args){
       List<Osoba> osoby  = new ArrayList<> ();
           osoby.add(new Osoba("Kowalski", 27));
           osoby.add(new Osoba("Nowak", 54));
           osoby.add(new Osoba("Lewandowski", 34));
           osoby.add(new Osoba("Wójcik", 62));
           osoby.add(new Osoba("Mazur", 19));

        double srednia = obliczSredniaWieku(osoby);
        System.out.println("Średnia wynosi: " + srednia);

        int max = maxwiek(osoby);
        System.out.println("Maksymalny wiek osoby z nazwiskiem, które zawiera litere 'a': " + max);

        String polacz = konaktenacja(osoby);
        System.out.println("Polączone nazwiska: " + osoby);

        double sredniaReduce = obliczSredniaReduce(osoby);
        System.out.println("Średnia obliczona za pomoca reduce wynosi: " + sredniaReduce);
    }
    private static double obliczSredniaWieku(List<Osoba> lista){
        return lista.stream()
                .mapToInt(Osoba::getWiek)
                .average()
                .orElse(0.0);
    }
    private static int maxwiek(List<Osoba> lista){
        return lista.stream()
                .filter(o-> o.getNazwisko().toLowerCase().contains("a"))
                .mapToInt(Osoba::getWiek)
                .max()
                .orElse(0);
    }
    private static String konaktenacja(List<Osoba> lista){
        return lista.stream()
                .map(Osoba::getNazwisko)
                .reduce((n1, n2) -> n1 + "," + n2)
                .orElse("");
    }
    private static double obliczSredniaReduce(List<Osoba> lista){
        return lista.stream()
                .mapToDouble(Osoba::getWiek)
                .reduce((w1, w2) -> w1 + w2)
                .orElse(0) / lista.size();
    }
}
