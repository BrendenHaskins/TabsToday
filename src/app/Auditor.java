package app;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Utility class used for general identity access management.
 * currentUser: the User object representing the user currently logged in, if any.
 * isLoggedIn: whether any user is currently logged in.
 * knownUsers: all users known by the instance, stored in their User objects.
 */
public class Auditor {
    private static User currentUser;
    private static boolean isLoggedIn;
    private static ArrayList<User> knownUsers = new ArrayList<>();

    /**
     * Given a plaintext pin, encrypt pin and attempt to log in user by encrypted pin.
     * @param pin the pin to attempt login.
     * @return the result of the login attempt.
     */
    public static boolean loginUser(String pin) {
        String hiddenPin = encryptPin(pin).toString();
        for(User user : knownUsers) {
            if(user.getPin().equals(hiddenPin)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    /**
     * Accepts a pin and encrypts it using SHA-256.
     * @param inputPin pin to be encrypted
     * @return a String with the encrypted pin
     */
    public static String encryptPin(String inputPin) {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] lockedPin = md.digest(inputPin.getBytes());
            StringBuilder hexString = new StringBuilder();

            for(byte b : lockedPin){
                hexString.append(String.format("%02x",b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e){
            throw new NoSuchElementException("ENCRYPT PIN ERROR: " + e);
        }
    }

    public static boolean addKnownUser(User user) {
        knownUsers.add(user);
        return true;
    }

    //getters and setters

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Auditor.currentUser = currentUser;
    }

    public static boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public static void setIsLoggedIn(boolean isLoggedIn) {
        Auditor.isLoggedIn = isLoggedIn;
    }

    public static ArrayList<User> getKnownUsers() {
        return knownUsers;
    }


    public static void setKnownUsers(ArrayList<User> knownUsers) {
        Auditor.knownUsers = knownUsers;
    }
}
