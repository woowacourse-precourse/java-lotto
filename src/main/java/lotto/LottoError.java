package lotto;

public class LottoError {

    public static void illegalArgumentException(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
        throw new IllegalArgumentException();
    }
}
