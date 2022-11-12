package lotto;

public class Validation {
    public static boolean thousandUnit(int num) {
        return num%1000 == 0;
    }

    public static boolean lottoNumRange(int num) {
        return 1 <= num && num <= 45;
    }
}
