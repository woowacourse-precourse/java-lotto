package lotto;

public class Message {
    private static final String ERROR_MESSAGE = "[ERROR] %s";

    public static void printErrorMessage(Exception e){
        System.out.println(String.format(ERROR_MESSAGE, e.getMessage()));
    }
}
