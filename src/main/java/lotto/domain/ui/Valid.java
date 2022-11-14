package lotto.domain.ui;

public class Valid {
    public static void IllegalArgumentException(String message) throws IllegalArgumentException {
        System.out.println(message);
        throw new IllegalArgumentException();
    }

}
