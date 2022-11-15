package view;

public class ExceptionHandlerUI {
    private final String errorStatus = "[ERROR] ";

    public void printErrorMessage(String errorMessage){
        System.out.println(errorStatus + errorMessage);
    }
}
