package com.example.wt_laba2.bean;

import com.example.wt_laba2.exception.DAOException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class representing a user entity.
 */
public class User {

    /** The unique identifier for the user. */
    private int id;

    /** The user's login. */
    private String Login;

    /** The user's password salt. */
    private final static String salt = "";

    /** The user's hashed password. */
    private String Password;

    /** The role of the user. */
    private String role = "user";

    /** Indicates if the user is banned or not. */
    private boolean ban = false;

    /**
     * Gets the user's login.
     * @return the user's login
     */
    public String getLogin() {
        return Login;
    }

    /**
     * Sets the user's login.
     * @param login the user's login to set
     */
    public void setLogin(String login) {
        Login = login;
    }

    /**
     * Gets the user's hashed password.
     * @return the user's hashed password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Sets the user's hashed password.
     * @param password the user's hashed password to set
     */
    public void setPassword(String password) {
        Password = password;
    }

    /**
     * Generates the SHA-512 hash for the given password.
     * @param Password the password to hash
     * @return the SHA-512 hashed password
     * @throws DAOException if there's an issue with the hashing algorithm
     */
    public static String getHashSha512Password(String Password) throws DAOException {
        String passwordHash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(Password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            passwordHash = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new DAOException("Algorithm wasn't found", e);
        }
        return passwordHash;
    }

    /**
     * Gets the role of the user.
     * @return the role of the user
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     * @param role the role of the user to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Checks if the user is banned.
     * @return true if the user is banned, otherwise false
     */
    public boolean isBan() {
        return ban;
    }

    /**
     * Sets the ban status of the user.
     * @param ban the ban status to set
     */
    public void setBan(boolean ban) {
        this.ban = ban;
    }

    /**
     * Gets the unique identifier for the user.
     * @return the unique identifier for the user
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the user.
     * @param id the unique identifier for the user to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
