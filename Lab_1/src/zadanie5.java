import java.util.Scanner;

public class zadanie5 {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe");
        int liczba = scanner.nextInt();

        for(int i = 0; i<liczba; i++){
            System.out.println("Dowolny komunikat");
        }
    }
}
