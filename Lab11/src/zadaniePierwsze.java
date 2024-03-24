import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MetodyPomocznicze {
    public static void znajdzOstatniaLitere(String napis) {
        System.out.println(napis.charAt(napis.length() - 1));
    }
    public void zmienTrzyPierwszeLiteryNaWielkie(String napis){
        if(napis.length() >= 3){
            System.out.println(napis.substring(0,3).toUpperCase() + napis.substring(3));
        }
        else{
            System.out.println(napis.toUpperCase());
        }
    }
    public static void usunMiesiaceBezE(List<String> miesiace){
        miesiace.removeIf(miesiac -> !miesiac.contains("e"));
    }
}
public class zadaniePierwsze{
    public static void main(String[] args){
        List<String> miesiace = new ArrayList<>(Arrays.asList("styczeń", "luty", "marzec", "kwiecień", "maj", "czerwiec",
                "lipiec", "sierpień", "wrzesień", "październik", "listopad", "grudzień"));

        miesiace.forEach(MetodyPomocznicze::znajdzOstatniaLitere);

        MetodyPomocznicze metodyPomocnicze = new MetodyPomocznicze();
        miesiace.forEach(metodyPomocnicze::zmienTrzyPierwszeLiteryNaWielkie);

        metodyPomocnicze.usunMiesiaceBezE(miesiace);
        System.out.println(miesiace);
    }
}
