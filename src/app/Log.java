package app;


import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

/**
 * Object class for creating log objects.
 * user: the user performing the action which generated the log.
 * action: what the user did.
 * date: when the user did it.
 * pipe: Streams instance for writing logs as they are created.
 */
public class Log implements Serializable {
    User user;
    String action;
    Date date = new Date();
    //Streams pipe = new Streams();

    public Log(User user, String action) throws IOException {
        this.user = user;
        this.action = action;

        Streams pipe = new Streams();
        pipe.logsWrite(this);
    }

    @Override
    public String toString() {
        return "User: " + this.user +
                " Action: " + this.action;
    }
}
