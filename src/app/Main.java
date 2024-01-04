package app;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Driver class for creating an instance of TabsToday, and testing all implementations
 * TODO: Last implementation was reading games file and writing all games to shelf. Reading shelf next.
 * This is a test of the github repo.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Auditor.setCurrentUser(new User("Brenden Haskins","1234",true));

        ArrayList<Double> prizes = new ArrayList<>();
        prizes.add(10.0);
        prizes.add(20.0);
        prizes.add(100.0);
        prizes.add(500.0);

        ArrayList<Double> prizesTwo = new ArrayList<>();
        prizesTwo.add(50.0);
        prizesTwo.add(50.0);
        prizesTwo.add(200.0);
        prizesTwo.add(400.0);


        Game testGame = new Game(1,1250, "Brenden's Game",1.00,prizes,new ArrayList<>(),0,0.0);
        Game secondGame = new Game(2,1000,"Second Game",2.00,prizesTwo,new ArrayList<>(),0,0.0);
        Streams pipe = new Streams();
        System.out.println(pipe.readLogsFile());
    }
}
