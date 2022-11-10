package lotto.infrastructure.util;

public class NumbersSeparator {

    public static String[] generate(String givenString) {
        return givenString.split(",");
    }
}
