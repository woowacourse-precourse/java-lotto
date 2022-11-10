package lotto;

public class ValidationUtil {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public static boolean isInRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    public static boolean isInRange(String str) {
        if (!str.matches("[1-9]{1,2}")) {
            throw new IllegalArgumentException("[ERROR] 0 이상의 숫자만 입력하실 수 있습니다.");
        }
        if (isInRange(Integer.parseInt(str))) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
