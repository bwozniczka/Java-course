import java.util.ArrayList;
import java.util.List;

public class Gra {
    private List<Gracz> gracze;
    private Talia talia;

    public Gra(Talia talia){
        this.talia = talia;
        this.gracze = new ArrayList<>();
    }
}
