package lotto;

public class Error {
    private static final String ERROR = "[ERROR]";

    public static void error(String errorMessage) {
        String output = ERROR + errorMessage;
        System.out.println(output);
        throw new IllegalArgumentException();
    }
}
