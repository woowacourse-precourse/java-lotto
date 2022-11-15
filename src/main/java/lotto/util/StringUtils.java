package lotto.util;

public class StringUtils {

    public static boolean isDigit(String number) {
        return number.chars()
            .allMatch(Character::isDigit);
    }

}
