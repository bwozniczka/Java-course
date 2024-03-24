public class NoCardException extends Exception {
    public NoCardException(){
        super("Brak dostępnych kart w tali.");
    }
}
