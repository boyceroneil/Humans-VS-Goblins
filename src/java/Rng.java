import java.util.*;
public class Rng {
    public int returnRandom(int x){
        Random rand = new Random();
            int y = rand.nextInt(x);
            return y;
        }
    }

