package lotto.util;

public class Util {
    public static String removeSpace(String input) {
        return input.replaceAll("\\s", "");
    }

    public static void verifyRangeOfLottoNumber(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }
}
