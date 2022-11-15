package Entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class Account implements Serializable {
    /**
     * Abstract class which functions as the base for all account types.
     *
     * UserName :The username associated with the account.
     * password: The password associated with the account.
     * createdOn: Date of the accounts' creation.
     */
    private String UserName;
    private final String password;
    private Date createdOn;

    public Account(String name, String pass){
        /**
         * Constructor for the account class.
         */
        this.UserName = name;
        this.password = pass;
        this.createdOn = new Date();
    }

    public String getUserName(){
        /**
         * Returns the username of the account.
         */
        return this.UserName;
    }

    public boolean confirmPassword(String pass){
        /**
         * Returns a boolean. True if the given string matches the account password, false otherwise.
         */
        return (Objects.equals(this.password, pass));
    }

    public String getCreatedOn(){
        /**
         * Returns the date of the account creation in string form.
         */
        SimpleDateFormat formatted = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatted.format(this.createdOn);
    }
}
