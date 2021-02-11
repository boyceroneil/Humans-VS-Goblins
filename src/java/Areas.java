import java.util.*;
public class Areas {
    String name;
    List<String> description = new ArrayList<>();
    List<String> exits = new ArrayList<>();
    List<Goblin> bad = new ArrayList<>();//help spawn new enemies
    ArrayList<Items> item = new ArrayList<>();//every area will have a list of enemy
    int number;
    public Areas(int number){
        this.number = number;
    }

}
