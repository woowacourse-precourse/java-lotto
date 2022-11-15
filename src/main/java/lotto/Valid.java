package lotto;

public class Valid {

    public static final boolean VALID = true;
    public static final boolean INVALID = false;

    public static boolean validNumber(String input) {
        if (input.isEmpty()) {
            return INVALID;
        }

        return VALID;
    }
}
