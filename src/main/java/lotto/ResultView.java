package lotto;

public class ResultView {
    public static void exit(Throwable error) throws IllegalArgumentException {
        String errMessage = "[ERROR] " + error.getMessage();
        System.out.println(errMessage);
        throw new IllegalArgumentException(errMessage);
    }

}
