package lotto.check;

public class MoneyCheck {

    private static final String errMsg = "1000원 단위로 숫자를 입력해 주세요.";

    public static Integer check(String money) {
        if (!isMoney(money)) {
            throw new IllegalArgumentException(errMsg);
        }
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException(errMsg);
        }
        return Integer.parseInt(money);
    }

    private static boolean isMoney(String money) {
        char[] chars = money.toCharArray();
        for (char c : chars) {
            if (!isDigit(c)) return false;
        }
        return true;
    }

    private static boolean isDigit(char c) {
        if (c < '0' && c > '9') return false;
        return true;
    }
}
