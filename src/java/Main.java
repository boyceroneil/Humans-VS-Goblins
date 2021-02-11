import javax.xml.stream.events.Characters;
import java.nio.charset.*;
import java.nio.*;
import java.util.*;
public class Main {
    public static GameLogic gl = new GameLogic();//once game is launch the goblin will be in the array
    public static void main(String[] args) {
        GameObjects.initializeEnemy();
        GameObjects.initializeItem();
        //enemyThread et = new enemyThread(gl);
        //et.startEnemyThread();
        while(true){
            game_loop();
        }
    }

    public static void game_loop() {
        gl.waitForCommand();

    }

//    Charset utf8 = StandardCharsets.UTF_8;
//    String rawString = "Entwickeln Sie mit Vergnügen";
//    ByteBuffer buffer = StandardCharsets.UTF_8.encode(rawString);
//
//    String utf8EncodedString = StandardCharsets.UTF_8.decode(buffer).toString();
//    int health, strength, defense, speed, movement;
//    String name;
//    human player1 = new human(300, 99, 30, 2, 2, "jo");
//    goblin enemy1 = new goblin(200, 49, 30, 6, 1, "po");
//   // assertEquals(rawString, utf8EncodedString);
}
