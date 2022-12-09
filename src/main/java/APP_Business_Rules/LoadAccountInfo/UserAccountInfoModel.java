package APP_Business_Rules.LoadAccountInfo;

import java.io.Serializable;

public class UserAccountInfoModel implements Serializable {


    /**
     * The username chosen by the user.
     */
    private String username;

    /**
     * The Bio chosen by the user, It will be blank if they haven't chosen a bio.
     */
    private String bio = "";

    public UserAccountInfoModel(String username){
        this.username = username;
    }
    /**
     * getUser:
     * A method that returns the username corresponding to the UserAccountInfoModel.
     *
     * @return The username stored in the UserAccountInfoModel.
     *
     */

    public String getUser(){
        return username;
    }
    /**
     * getBio:
     * A method that returns the Bio corresponding to the UserAccountInfoModel.
     *
     * @return The Bio stored in the UserAccountInfoModel.
     *
     */



    public String getBio(){
        return bio;
    }

    /**
     * changeBio:
     * A method that changes the stored Bio corresponding to the UserAccountInfoModel.
     *
     * @param newbio  The new Bio to be  stored in the UserAccountInfoModel.
     *
     */


    public void changeBio(String newbio){
        this.bio = newbio;
    }

}




