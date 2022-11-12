package lotto.utils;

public class Utils {

    private static final String STRING_REGEX = "\\s";
    private static final String BLANK = "";

    public static String deleteAllString(String string) {
        return string.replaceAll(STRING_REGEX, BLANK);
    }

}
