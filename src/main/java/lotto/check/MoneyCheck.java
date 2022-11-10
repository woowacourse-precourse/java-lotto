package lotto.checker;

public class MoneyChecker implements Checker<Integer> {

    @Override
    public Integer check(String money) {
        if (!isMoney(money)) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(money);
    }

    private boolean isMoney(String money) {
        char[] chars = money.toCharArray();
        for (char c : chars) {
            if (!isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDigit(char c) {
        if (c < '0' && c > '9') {
            return false;
        }
        return true;
    }
}
