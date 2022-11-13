package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR_INPUT_MONEY = "[ERROR] 숫자만 입력해주세요.";
    private static final String NOT_VALID_MONEY = "[ERROR] 1000원 단위로 입력해주세요.";
    private final int money;

    public Money(String money) {
        try {
            validateMoney(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
        }
        this.money = convertToInt(money);
    }

    public void validateMoney(String money) {
        if (!isDigit(money)) {
            throw new IllegalArgumentException(ERROR_INPUT_MONEY);
        }
        if (!isCalculator(money)) {
            throw new IllegalArgumentException(NOT_VALID_MONEY);
        }
    }

    public static int convertToInt(String money) {
        return Integer.parseInt(money);
    }

    private boolean isCalculator(String money) {
        int convertMoney = convertToInt(money);
        if (convertMoney % 1000 != 0 || convertMoney < 0) {
            return false;
        }
        return true;
    }

    public static boolean isDigit(String money) {
        if (money != null && !money.matches("-?\\d+")) {
            return false;
        }
        return true;
    }


}
