package lotto.service;

import java.util.List;
import java.util.regex.Pattern;

public class Validation {

    public static boolean isInRange(int lower, double x, int upper) {
        return lower <= x && x <= upper;
    }

    public static boolean isUp(int lower, double x) {
        return lower <= x;
    }

    public static boolean isDown(double x, int upper){
        return x <= upper;
    }

    public static boolean isMultiplesOf1000(int x) {
        return x%1000 == 0;
    }

    public static boolean isInLotto(List<Integer> lst, int i) {
        return lst.contains(i);
    }
}
