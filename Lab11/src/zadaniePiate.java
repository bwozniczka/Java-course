import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class zadaniePiate {
    public static void main(String[] args){
        double[] randomNum = new Random().doubles(10, -100, 100).toArray();
        Arrays.stream(randomNum)
                .forEach(System.out::println);

        List<Osoba> osoby = generujOsoby();
        osoby.forEach(System.out::println);
    }
    private static List<Osoba> generujOsoby(){
        Random random = new Random();
        return random.ints(10, 10,80)
                .mapToObj(wiek -> new Osoba(generujNazwisko(), wiek))
                .toList();
    }
    private static String losoweNazwisko(){
        String[] nazwiska = {"Kowalski", "Nowak", "Wiśniewski", "Wójcik",
                "Kowalczyk", "Kamiński", "Lewandowski", "Zieliński", "Mazur"};
        Random random = new Random();
        return nazwiska[random.nextInt(nazwiska.length)];
    }

    private static String generujNazwisko() {
        Random random = new Random();
        String losoweNazwisko = random.ints(5, 'A', 'Z' + 1)
                .mapToObj(c -> (char) c)
                .map(Object::toString)
                .collect(Collectors.joining());
        return losoweNazwisko;
    }
}
