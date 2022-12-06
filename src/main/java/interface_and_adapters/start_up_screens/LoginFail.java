package interface_and_adapters.start_up_screens;

public class LoginFail extends RuntimeException{

    public LoginFail(String error){
        super(error);
    }
}
