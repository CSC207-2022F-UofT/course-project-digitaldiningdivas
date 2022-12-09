package APP_Business_Rules.LoadAccountInfo;

public class ChangeBioController {

    /**
     * The username chosen by the user.
     */
    private String username;

    /**
     * The new Bio chosen by the user.
     */

    private String newbio;

    /**
     * This Class Is a Controller that uses the MVP model to change the bio stored in the CSV file.
     * ( I still consider it as a controller).
     */

    public ChangeBioController(String username, String newbio) {
        this.username = username;
        this.newbio = newbio;
    }
    /**
     * ChangeBioController:
     * method that allows the user to change their bio by changing the UserAccountInfomodel in the csv file.
     *
     */

    public void UpdateBio(){
        PullAccountInputBoundary User = new PullAcountInteractor(username);
        User.UpdateBio(username, newbio);

    }



}
