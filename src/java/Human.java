import java.util.ArrayList;

public class Human {
    int health, strength, defense, speed, movement, acc;
    String name;
    ArrayList<Items> item = new ArrayList<>();//every area will have a list of enemy
    ArrayList<Items> equippedItems = new ArrayList<>();//every area will have a list of enemy
    public Human(){
        this.health = 200;
        this.strength= 25;
        this.defense= 20;
        this.speed = 10;
        this.name = "thing1";
        this.acc = 80;
        this.movement = 0;//room that you are in
    }
    public void wear(String[] words){
        if(equippedItems.size()==0){
            for(int i = 0; i< item.size(); i++){
                if(words[1].equalsIgnoreCase(item.get(i).id)&& item.get(i).isWearable){
                    equippedItems.add(item.get(i));
                    System.out.println("You are wearing " + item.get(i).name);
                    item.remove(i);

                    break;
                }
            }
        }
        else{
            boolean isWearing = false;
            for(int i =0; i< equippedItems.size(); i++){
                for(int z=0; z < item.size(); z++){
                    if(words[1].equalsIgnoreCase(item.get(z).id) && item.get(z).isWearable){
                        if(item.get(z).wearLocation.equals(equippedItems.get(i).wearLocation)){
                            System.out.println(("You already have an item in this location"));
                            isWearing = true;
                        }
                    }
                }
                if(!isWearing){
                    equippedItems.add(item.get(i));
                    System.out.println("You are wearing " + item.get(i).name);
                    item.remove(i);
                    break;
                }
            }
        }
    }
    public void remove(String[] words){
        for(int i =0; i < equippedItems.size();i++){
            if(equippedItems.get(i).id.equals(words[1])){
                System.out.println("Removing " + equippedItems.get(i).id);
                item.add(equippedItems.get(i));
                this.strength-= equippedItems.get(i).power;
                equippedItems.remove(i);
            }
        }
    }




    public Human(int health,int strength,int defense,int speed,  int movement, String name){
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.speed = speed;
        this.name = name;
        this.movement = movement;
    }

    public void equips(){
        for(int i=0; i<equippedItems.size();i++){
            System.out.println(equippedItems.get(i).name + ":" + equippedItems.get(i).wearLocation);
            this.strength+= equippedItems.get(i).power;
        }

    }

    public void search(){
        System.out.println("health "+ health);
        System.out.println("strength "+strength);
        System.out.println("defense "+defense);
        System.out.println("speed "+speed);

    }
    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMovement() {
        return movement;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public void setName(String name) {
        this.name = name;
    }


}

