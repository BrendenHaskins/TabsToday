package app;

import java.io.IOException;
import java.io.Serializable;

/**
 * Object class for creating User objects.
 * fullName: the user's full name.
 * pin: the user's pin, encrypted using Auditor's encryptPin method.
 * isAdmin: the user's status as an administrator.
 */
public class User implements Serializable {
    private String fullName;
    private String pin;
    private boolean isAdmin;

    public User(String fullName, String pin, boolean isAdmin) throws IOException {
        this.fullName = fullName;
        this.pin = Auditor.encryptPin(pin);
        this.isAdmin = isAdmin;

        new Log(Auditor.getCurrentUser(),"CREATED USER: " + this.toString());
        Auditor.addKnownUser(this);
    }

    //getters and setters

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
