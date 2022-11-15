package lotto.service;

import java.util.List;
import java.util.regex.Pattern;

public class Validation {

    public static boolean isInRange(int lower, double x, int upper) {
        return lower <= x && x <= upper;
    }

    public static void isUp(int lower, double x) {
        if(lower > x) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위가 벗어났습니다.");
        }
    }

    public static void isMultiplesOf1000(int x) {
        if(x%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000의 배수가 아닙니다.");
        }
    }

    public static void isLotto(List<Integer> lst) {
        boolean tmp = lst.stream().allMatch(x->isInRange(1, x, 45));
        if (!tmp) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자(1~45)의 범위를 벗어났습니다.");
        }
    }

    public static void isNumber(String s) {
        boolean tmp = Pattern.matches("^[0-9]*$", s);
        if (!tmp) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닙니다.");
        }
    }

    public static void isSixNumber(List<Integer> lst) {
        if (lst.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개가 아닙니다.");
        }
    }

    public static void isNonContains(List<Integer> lst, int n) {
        if(lst.contains(n)){
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자를 입력했습니다.");
        }
    }
}