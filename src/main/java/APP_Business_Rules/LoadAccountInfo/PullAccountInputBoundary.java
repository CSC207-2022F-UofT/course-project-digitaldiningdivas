package APP_Business_Rules.LoadAccountInfo;

public interface PullAccountInputBoundary {
    /**
     * This is an interface That used to Change the bio.
     */

    String PullAccount(String username);

    void UpdateBio(String username, String newbio);
}

