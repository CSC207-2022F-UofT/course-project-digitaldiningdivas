package APP_Business_Rules.LoadAccountInfo;

public class PullAccountInfoController {

    /**
     * The Username corresponding to the UserAccountInfomodel.
     */
    private String username;

    /**
     * This Class Is a Controller that uses the MVP model to access bio stored in the CSV file.
     * ( I still consider it as a controller).
     */

    public PullAccountInfoController(String username) {
        this.username = username;
    }

    /**
     * GetBio:
     * method that allows the user to change to access their bio by accessing the UserAccountInfomodel in the csv file.
     *
     * @return whether the user exists.
     */

    public String GetBio(){
        PullAccountInputBoundary User = new PullAcountInteractor(username);
        return User.PullAccount(username);

    }



}
