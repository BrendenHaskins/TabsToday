package app;


import java.io.IOException;
import java.util.Date;

/**
 * Object class for creating log objects.
 * user: the user performing the action which generated the log.
 * action: what the user did.
 * date: when the user did it.
 * pipe: Streams instance for writing logs as they are created.
 */
public class Log {
    User user;
    String action;
    Date date;
    Streams pipe = new Streams();

    public Log(User user, String action, Date date) throws IOException {
        this.user = user;
        this.action = action;
        this.date = date;

        pipe.logsWrite(this);
    }
}
