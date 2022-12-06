package interface_and_adapters.start_up_screens;

public class SignUpFail extends RuntimeException{
    public SignUpFail(String error) {
        super(error);
    }
}
