package lotto;

public class ValidationUtil {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_COUNT = 6;

    public static void isValidNum(String str) {
        int number = Integer.parseInt(str);
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void isValidCount(String[] array) {
        if (array.length != LOTTO_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6개의 숫자여야 합니다.");
        }
    }

    public static boolean isValid(String str) {
        String[] split = str.split(",");
        isValidCount(split);
        for (String s : split) {
            isValidNum(s);
        }
        return true;
    }
}
