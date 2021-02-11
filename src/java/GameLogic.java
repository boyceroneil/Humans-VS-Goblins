import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class GameLogic {
    @Override
    public String toString() {
        return "GameLogic{}";
    }

    public GameLogic(){
        GameObjects.area.add(new Areas(0));
        List<String> roomInfo = new ArrayList<>();
        GameObjects.area.add(new Areas(1));
        GameObjects.area.get(0).name = "You're position here: ";
        GameObjects.area.get(0).description.add("Description line 1");
        GameObjects.area.get(0).description.add("Description line 1");
        GameObjects.area.get(0).description.add("Description line 1");
        GameObjects.area.get(0).description.add("Description line 1");
        GameObjects.area.get(0).exits.add("East 2");
        GameObjects.area.get(0).exits.add("North 4");
        try{

            roomInfo = readLines("textFiles\\RoomDescription.txt");
        } catch(IOException e){
            e.printStackTrace();
        }
        for(int i =0; i< roomInfo.size(); i++){
            String[] first = roomInfo.get(i).split(" ");
            String[] rest = roomInfo.get(i).split(":");

            if(first[0].equals("RoomName:")){
                int currentRoom = GameObjects.area.size();
                GameObjects.area.add(new Areas(currentRoom));
                GameObjects.area.get(GameObjects.area.size()-1).name = rest[1];
                GameObjects.area.get(GameObjects.area.size()-1).number = (currentRoom);
                int counter =0;
                for(int z= 0; z< roomInfo.size(); z++){
                    String[] nextFirst = roomInfo.get(z).split(" ");
                    if(nextFirst[0].equals("RoomName:")){
                        counter++;
                    }
                    if(counter==currentRoom){
                        if(nextFirst[0].equals("Description:")){
                            String[] nextRest = roomInfo.get(z).split(":");
                            GameObjects.area.get(GameObjects.area.size()-1).description.add(nextRest[1]);
                        }
                    }
                }
                counter = 0;
                for(int z =0; z<roomInfo.size(); z++){
                    String[] nextFirst = roomInfo.get(z).split(" ");
                    if(nextFirst[0].equals("RoomName:")){
                        counter++;
                    }
                    if(counter== currentRoom){
                        if(nextFirst[0].equals("Exit:")){
                            String[] nextRest = roomInfo.get(z).split(":");
                            GameObjects.area.get(GameObjects.area.size()-1).exits.add(nextRest[1]);
                        }
                    }
                }
            }
        }

    }
    public List<String> readLines(String filename) throws IOException{
        FileReader fileReader = new FileReader(filename);
        BufferedReader buffer = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();
        String line= null;
        while((line = buffer.readLine()) != null){
            lines.add(line);
        }
        buffer.close();
                return lines;
    }
    public void waitForCommand(){
        if(GameObjects.hu.movement==0){
            createHuman();
        }
        System.out.println("What will you do: ");
        Scanner input = new Scanner(System.in);
        String use = input.nextLine();

        String[] words = use.split(" ");
        processCommand(words);
    }



    public void processCommand(String[] words) {
        if(words[0].equals(("search"))){
            search(words);
        }
        if(words[0].equals("summon")){
            summon(words);
        }
        if(words[0].equals("get")){
            get(words);
        }
        if(words[0].equals("create")){
            createItem(words);
        }
        if(words[0].equals("equip")){
            GameObjects.hu.equips();
        }
        if(words[0].equals("wear")){
            GameObjects.hu.wear(words);
        }
        if(words[0].equals("remove")){
            GameObjects.hu.remove(words);
        }
        if(words[0].equals("move")){
            move(words);
        }
    }

    public void summon(String[] words) {
        if(words.length ==1){
            System.out.println("what will you summon: ");
        }
        if(words.length ==2){
            for(int i =0; i< GameObjects.enemy.size(); i++){
                Goblin gobby = (Goblin) GameObjects.enemy.get(i);
                if(gobby.id.equalsIgnoreCase(words[1])){
                    for(int y = 0; y< GameObjects.area.size(); y++){
                        if(GameObjects.area.get(y).number == GameObjects.hu.movement){
                            try {
                                GameObjects.area.get(y).bad.add((Goblin) Class.forName(gobby.id).newInstance());
                                System.out.println("You summon a " + GameObjects.area.get(y).bad.get(GameObjects.area.get(y).bad.size() - 1).name);//.name after -1)
                            }catch(InstantiationException|IllegalAccessException|ClassNotFoundException e){
                                e.printStackTrace();;
                            }
                        }

                    }
                }

            }
        }
    }

    public void createItem(String[] words){
        if(words.length == 1){
            System.out.println("What do you want to make: ");
        }
        if(words.length ==2 ){
            for(int i=0; i< GameObjects.itemBank.size(); i++){
                Items localItem = (Items) GameObjects.itemBank.get(i);
                if(localItem.id.equalsIgnoreCase(words[1])){
                    for(int y =0; y< GameObjects.area.size();y++){
                        if(GameObjects.area.get(y).number == GameObjects.hu.movement){
                            try{
                                GameObjects.area.get(y).item.add((Items) Class.forName(localItem.id).newInstance());

                            } catch(InstantiationException | IllegalAccessException | ClassNotFoundException e){
                                e.printStackTrace();
                            }
                            System.out.println("You created a" + GameObjects.area.get(y).item.get(GameObjects.area.get(y).item.size() -1).name);
                        }
                    }
                }
            }
        }
    }
    public void get(String[] words){
        if(words.length==1){
            System.out.println("What do you want to receive");
        }
        if(words.length == 2){
            for(int i =0; i< GameObjects.itemBank.size(); i++){
                for(int j=0; j<GameObjects.area.size(); j++){
                    if(GameObjects.area.get(j).number== GameObjects.hu.movement){
                        for(int l=0; l < GameObjects.area.get(j).item.size(); l++){
                            if(words[1].equalsIgnoreCase(GameObjects.area.get(j).item.get(l).id)){
                                Items localItems = GameObjects.area.get(j).item.get(l);

                                GameObjects.hu.item.add(localItems);
                                System.out.println("You've received "+ localItems.name);
                                GameObjects.area.get(j).item.remove(l);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    public void search(String[] words) {
        if(words.length ==1 ){
            for(int i=0; i< GameObjects.area.size(); i++){
                if(GameObjects.area.get(i).number == GameObjects.hu.movement){//will get the current room that player is standing on
                    System.out.println(GameObjects.area.get(i).name);
                    for(int y=0; y< GameObjects.area.get(i).description.size(); y++){// will list all the options that are available at current position
                        System.out.println(GameObjects.area.get(i).description.get(y));
                    }
                    System.out.println("Exits area:");
                    for(int j =0; j< GameObjects.area.get(i).exits.size(); j++){//will list all the exits that are currently available
                        String exitName = GameObjects.area.get(i).exits.get(j);
                        String[]exitNames = exitName.split(" ");//splits the directions and number of exits
                        System.out.println((exitNames[0]));;
                    }
                    for(int x = 0; x < GameObjects.area.get(i).bad.size(); x++){
                        System.out.println(GameObjects.area.get(i).bad.get(x).description);
                    }
                    for(int t=0; t < GameObjects.area.get(i).item.size(); t++){
                        System.out.println(GameObjects.area.get(i).item.get(t).description);
                    }
                }
            }
        }
        if(words.length ==2){
            if(words[1].equals("me")){
                GameObjects.hu.search();
                System.out.println("You are holding: ");
                for(int i=0; i<GameObjects.hu.item.size(); i++) {
                    System.out.println(GameObjects.hu.item.get(i).name);
                }
            }
            for(int y = 0; y< GameObjects.area.size(); y++){
                if(GameObjects.area.get(y).number == GameObjects.hu.movement){
                    for(int i =0; i<GameObjects.area.get(y).bad.size(); i++){
                        if(words[1].equalsIgnoreCase(GameObjects.area.get(y).bad.get(i).id)){
                            GameObjects.area.get(y).bad.get(i).search();
                        }
                    }
                }
            }

        }
    }
    public void  move(String[] words){
        if(words.length ==1 ){
            System.out.println("Move where");
        }
        if(words.length ==2){
            for(int i =0; i< GameObjects.area.size();i++){
                if(GameObjects.area.get(i).number == GameObjects.hu.movement){
                    for(int y =0; y< GameObjects.area.get(i).exits.size(); y++) {
                        String leaveRequest = GameObjects.area.get(i).exits.get(y);
                        String [] leaveArray = leaveRequest.split(" ");
                        if(words[1].equalsIgnoreCase(leaveArray[1])){
                            GameObjects.hu.movement = Integer.parseInt(leaveArray[2]);
                            System.out.println("You are leaving "+ leaveArray[1]);
                            String[] badProgram = new String[1];
                            badProgram[0]= "nada";
                            search(badProgram);
                        }
                    }
                }
            }
        }
    }

    public void createHuman() {
        System.out.println("welcome to the world. what is your name");
        Scanner input = new Scanner(System.in);
        GameObjects.hu.name = input.next();
        GameObjects.hu.health = 200;
        GameObjects.hu.strength= 25;//how much damage you can do minus defense
        GameObjects.hu.defense= 20;
        GameObjects.hu.speed = 10;
        GameObjects.hu.movement = 2;//starting area
    }
}
