import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {

    Goblin gob;
    @BeforeEach
    void setUp(){
        gob = new Goblin(250,30,15,10,2,2,"Dicky","Goblin","Dick");

    }

    @Test
    void getHealth() {
        assertEquals(250, gob.getHealth());
    }

    @Test
    void testGetHealth() {
    }

    @Test
    void setHealth() {
    }

    @Test
    void getStrength() {
    }

    @Test
    void setStrength() {
    }

    @Test
    void getDefense() {
    }

    @Test
    void setDefense() {
    }

    @Test
    void getSpeed() {

    }

    @DisplayName("Testing setSpeed")
    @Test
    void setSpeed() {
        gob.setSpeed(30);
        assertEquals(30,gob.getSpeed());
    }


    @Test
    void getMovement() {
    }

    @DisplayName("Testing setMovement")
    @Test
    void setMovement() {
    }

    @Test
    void getAcc() {
    }

    @DisplayName("Testing setAcc")
    @Test
    void setAcc() {
    }

    @Test
    void getName() {
    }

    @DisplayName("Testing setName")
    @Test
    void setName() {
    }

    @Test
    void getId() {
    }

    @DisplayName("Testing setId")
    @Test
    void setId() {

    }

    @Test
    void getDescription() {
    }

    @Test
    void setDescription() {
    }
    @DisplayName("Testing a group of methods")
    @Test
    void groupedAssertions(){
        gob.setHealth(400);
        gob.setStrength(30);
        gob.setDefense(32);
        gob.setName("Dickersin");
        gob.setDescription("I'm gonna murk you");
        assertAll("Testing get and set",
                ()-> assertEquals(233, gob.getHealth(),"HP is not exact"),
                ()-> assertEquals(233, gob.getStrength(),"the strength is not accurate"),
                ()-> assertEquals(23, gob.getDefense(),"defense is not correct"),
                ()-> assertEquals("233", gob.getName(), " the name is not good"),
                ()-> assertEquals("I'm gonna murk you ", gob.getDescription(),"Might need to change"));
    }

    @Test
    void search() {
    }

    @Test
    void testToString() {
    }
}