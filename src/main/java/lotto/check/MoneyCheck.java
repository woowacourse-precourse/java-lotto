package lotto.check;

import lotto.domain.Const;

public class MoneyCheck {


    public static Integer check(String money) {
        if (!isMoney(money)) {
            throw new IllegalArgumentException(Const.NUM_ERRMSG);
        }
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException(Const.MONEY_ERRMSG);
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
