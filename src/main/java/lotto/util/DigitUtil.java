package lotto.util;

public class DigitUtil {

    public static boolean isDigit(String text) {

        for (char i : text.toCharArray()) {
            if (!Character.isDigit(i)) {
                return false;
            }
        }

        return true;
    }

}
