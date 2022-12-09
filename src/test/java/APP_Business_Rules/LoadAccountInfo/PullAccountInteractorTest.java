package APP_Business_Rules.LoadAccountInfo;



import org.junit.*;

import static org.junit.Assert.*;

public class PullAccountInteractorTest {

    // tests work locallly but no when pushed


    @Test()
    public void testsimplepull(){
        UserAccountInfoFile file = new UserAccountInfoFile("./AccountInfoTest.csv");
        UserAccountInfoModel model = new UserAccountInfoModel("test");
        file.save(model);
        PullAcountInteractor testinteractor = new PullAcountInteractor("test");
        assertEquals("", testinteractor.PullAccount("test") );
    }

    @Test()
    public void testchange(){
        UserAccountInfoFile file = new UserAccountInfoFile("./AccountInfoTest.csv");
        UserAccountInfoModel model = new UserAccountInfoModel("test");
        file.save(model);
        PullAcountInteractor testinteractor = new PullAcountInteractor("test");
        testinteractor.UpdateBio("test", "new");
        assertEquals("new", testinteractor.PullAccount("test") );
    }


    @Test()
    public void testchange2(){
        UserAccountInfoFile file = new UserAccountInfoFile("./AccountInfoTest.csv");
        UserAccountInfoModel model = new UserAccountInfoModel("test");
        file.save(model);
        PullAcountInteractor testinteractor = new PullAcountInteractor("test");
        testinteractor.UpdateBio("5", "new");
        assertEquals("5", testinteractor.PullAccount("test") );
    }


}
