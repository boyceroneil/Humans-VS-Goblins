import java.util.*;
public class GameObjects {
    static Human hu = new Human();
    static  Combat combo = new Combat();
    static Rng ran = new Rng();
    static ArrayList<Areas> area = new ArrayList<>();//create area objects where you can go to
    static List<Object> enemy = new ArrayList<>();//help spawn new enemies
    static List<Object> itemBank = new ArrayList<>();//every area will have a list of enemy

    public static void initializeEnemy(){//master list for all enemies
        enemy.add(new Goblin());// if i want to add new creatures then add here
    }

    public static void initializeItem(){
        itemBank.add(new Items());
        itemBank.add(new Sword());
        itemBank.add(new Shield());
        itemBank.add(new SpeedShoes());
        itemBank.add(new Helmet());
        itemBank.add(new Chestplate());

    }
}
