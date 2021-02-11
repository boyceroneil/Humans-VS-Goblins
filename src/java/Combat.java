public class Combat {
public void attack(String[] words){
    for(int i =0; i< GameObjects.area.size(); i++){
        for(int y = 0; y< GameObjects.area.get(i).bad.size();y++) {
            if (GameObjects.area.get(i).bad.get(y).id.equalsIgnoreCase(words[1])) {
                int enemyhit=GameObjects.ran.returnRandom(100);
                enemyhit += (GameObjects.area.get(i).bad.get(y)).acc;//this will have to be different
                if(enemyhit>50){
                    int enemyDamage = GameObjects.area.get(i).bad.get(y).strength - GameObjects.hu.defense; //GameObjects.ran.returnRandom(10);
                    GameObjects.hu.health = GameObjects.hu.health - enemyDamage ;//enemyDamage
                    System.out.println(("The " + GameObjects.area.get(i).bad.get(y).name + " the enemy did "+ enemyDamage + " damage"));
                }
                else{
                    System.out.println(" the enemy missed");
                    int humanHit = GameObjects.ran.returnRandom(100);
                    humanHit = enemyhit + (GameObjects.area.get(i).bad.get(y)).acc; //accuracy /2
                    if(humanHit>50){
                        int humanDamage = GameObjects.hu.strength - GameObjects.area.get(i).bad.get(y).defense;//GameObjects.ran.returnRandom(10);
                        GameObjects.area.get(i).bad.get(y).health = GameObjects.area.get(i).bad.get(y).health- humanDamage ;//- humanDamage
                        System.out.println("You hit for " + humanDamage);
                        if(GameObjects.area.get(i).bad.get(y).health <=0){
                            enemyDead(i,y);
                        }
                        else{
                            System.out.println("Miss");
                        }
                    }
                }

            }
        }
    }
}

    public void enemyDead(int i, int y) {
    System.out.println("This " + GameObjects.area.get(i).bad.get(y).name + " is dead");
    GameObjects.area.get(i).bad.remove(y);
    }
}
