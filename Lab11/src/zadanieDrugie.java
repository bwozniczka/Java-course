import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class zadanieDrugie {
    public static void main(String[] args){
        List<Double>  losoweLiczby = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            losoweLiczby.add(-100 + 200 * random.nextDouble());
        }
        losoweLiczby.forEach(System.out::println);
        try {
            double srednia = losoweLiczby.stream()
                    .filter(d -> d >= 0)
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElseThrow(() -> new IllegalStateException("Lista zawiera jedynie ujemne wartości."));

            System.out.println("Średnia arytmetyczna nieujemnych elementów: " + srednia);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
