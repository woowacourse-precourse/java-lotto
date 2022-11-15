package lotto;

import java.util.List;

public class Validation {

    static final int MONEY_UNIT = 1000;
    static final int LOTTO_MIN_NUM = 1;
    static final int LOTTO_MAX_NUM = 45;
    static final int LOTTO_SIZE = 6;

    public static boolean thousandUnit(int num) {
        return num % MONEY_UNIT == 0;
    }

    public static boolean lottoNumRange(int num) {
        return LOTTO_MIN_NUM <= num && num <= LOTTO_MAX_NUM;
    }

    public static boolean lottoLength(List<Integer> arr) {
        return arr.size() == LOTTO_SIZE;
    }
}
