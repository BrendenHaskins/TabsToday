package app;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Base class used for serializing objects - reads and writes text files for capturing/recording objects.
 */

public class Streams {
    //create files
    private static final File gamesFile = new File("src/files/games");
    private static final File usersFile = new File("src/files/users");
    private static final File logsFile = new File("src/files/logs");
    private static final File archiveFile = new File("src/files/archive");

    //create FileOutputStreams
    FileOutputStream gamesFOS = new FileOutputStream(gamesFile);
    FileOutputStream usersFOS = new FileOutputStream(usersFile);
    FileOutputStream logsFOS = new FileOutputStream(logsFile);
    FileOutputStream archiveFOS = new FileOutputStream(archiveFile);

    //create FileInputStreams
    FileInputStream gamesFIS = new FileInputStream(gamesFile);
    FileInputStream usersFIS = new FileInputStream(usersFile);
    FileInputStream logsFIS = new FileInputStream(logsFile);
    FileInputStream archiveFIS = new FileInputStream(archiveFile);

    //create ObjectOutputStreams
    ObjectOutputStream gamesOOS = new ObjectOutputStream(gamesFOS);
    ObjectOutputStream usersOOS = new ObjectOutputStream(usersFOS);
    ObjectOutputStream logsOOS = new ObjectOutputStream(logsFOS);
    ObjectOutputStream archiveOOS = new ObjectOutputStream(archiveFOS);

    //create ObjectInputStreams
    ObjectInputStream gamesOIS = new ObjectInputStream(gamesFIS);
    ObjectInputStream usersOIS = new ObjectInputStream(usersFIS);
    ObjectInputStream logsOIS = new ObjectInputStream(logsFIS);
    ObjectInputStream archiveOIS = new ObjectInputStream(archiveFIS);

    public Streams() throws IOException {
    }

    /**
     * Given a game object, accesses the game file object output stream to write the given game.
     * @param game the game to be written.
     * @return the result of attempting to write the game.
     * @throws IOException attempting to write the game has caused an IO exception.
     */
    public boolean gamesWrite(Game game) throws IOException {
        gamesOOS.writeObject(game);
        gamesOOS.flush();

        return true;
    }

    /**
     * Given a user object, accesses the user file object output stream to write the given user.
     * @param user the game to be written.
     * @return the result of attempting to write the user.
     * @throws IOException attempting to write the user has caused an IO exception.
     */
    public boolean usersWrite(User user) throws IOException {
        usersOOS.writeObject(user);
        usersOOS.flush();

        return true;
    }

    /**
     * Given a log object, accesses the log file object output stream to write the given log.
     * @param log the log to be written.
     * @return the result of attempting to write the log.
     * @throws IOException attempting to write the log has caused an IO exception.
     */
    public boolean logsWrite(Log log) throws IOException {
        logsOOS.writeObject(log);
        logsOOS.flush();

        return true;
    }

    /**
     * Given a game object, accesses the archive file object output stream to write the given game.
     * @param game the game to be written.
     * @return the result of attempting to write the game.
     * @throws IOException attempting to write the game has caused an IO exception.
     */
    public boolean archiveWrite(Game game) throws IOException {
        archiveOOS.writeObject(game);
        archiveOOS.flush();

        return true;
    }

    /**
     * Adds each game in games file to gameShelf.
     * @return the result of reading the file.
     * @throws IOException attempting to read the file has caused an IO exception.
     */
    public boolean readGamesFile() throws IOException, ClassNotFoundException {

       while(true) {
           try {
               Game.gameShelf.add((Game)gamesOIS.readObject());
           } catch (EOFException e) {
               break;
           }
       }

       return true;
    }

    /**
     * Writes each game from the game shelf to the games file.
     * @return the result of writing to the file.
     * @throws IOException attempting to write to the file has caused an IO exception.
     */
    public boolean writeGamesShelf() throws IOException {
        for(Game game : Game.gameShelf) {
            gamesOOS.writeObject(game);
        }

        return true;
    }

    public ArrayList<String> readLogsFile() {
        ArrayList<String> output = new ArrayList<>();
        while(true) {
            try {
                System.out.println("Value found");
                output.add(logsOIS.readObject().toString());
            } catch (EOFException e) {
                System.out.println("EOF");
                break;
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return output;
    }


}
