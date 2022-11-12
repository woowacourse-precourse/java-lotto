package lotto.service;

import java.util.List;
import java.util.regex.Pattern;

public class Validation {

    public static void isInRange(int lower, double x, int upper) {
        return lower <= x && x <= upper;
    }

    public static void isMultiplesOf1000(int x) {
        if (x%1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void isInLotto(List<Integer> lst, int i) {
        return lst.contains(i);
    }

    public static boolean isLottoNumber(String s) {
        final String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, s);
    }

}
