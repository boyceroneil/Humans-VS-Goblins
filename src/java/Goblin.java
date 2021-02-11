public class Goblin {
    int health, strength, defense, speed, movement, acc;
    String name, id, description;
    public Goblin(){
        this.health = 200;
        this.strength= 25;
        this.defense= 20;
        this.speed = 10;
        this.movement = 3;
        this.acc= 85;
        this.description ="I'm gonna f ya up ";
        this.name = "thing1";
        this.id = "Goblin";
    }
    public Goblin(int health, int strength,int defense,int speed,int movement,int acc
            ,String name,String id,String description){
        this.health=health;
        this.strength = strength;
        this.defense = defense;
        this.speed = speed;
        this.movement = movement;
        this.acc = acc;
        this.name = name;
        this.id = id;
        this.description = description;
    }
    public Goblin(int health, int strength,int defense,int speed
            ,String name,String id,String description){
        this.health=health;
        this.strength = strength;
        this.defense = defense;
        this.speed = speed;
        this.name = name;
        this.id = id;
        this.description = description;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //    public goblin(int health,int strength,int defense,int speed,  int movement, String name, String id){
//        this.health = health;
//        this.strength = strength;
//        this.defense = defense;
//        this.speed = speed;
//        this.name = name;
//        this.movement = movement;
//        this.id = id;
//    }
    public void search(){
        System.out.println(name + "\n strength " +strength +
                "\n defense" + defense + " \n speed " + speed
                + "\n description " + description);

    }

    @Override
    public String toString() {
        return "Goblin{" +
                "health=" + health +
                ", strength=" + strength +
                ", defense=" + defense +
                ", speed=" + speed +
                ", movement=" + movement +
                ", acc=" + acc +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
