package lotto;

public class Validation {
    private final static int ONE_LOTTO = 1000;
    private final static String ERROR_MESSAGE = "[ERROR] ";
    private final static String INVALID_MONEY_MESSAGE = "구입 금액은 " + ONE_LOTTO + "원 단위로만 입력 가능합니다.";
    private final static String INVALID_TYPE_MESSAGE = "숫자만 입력 가능합니다.";


    public static void isNumberType(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_TYPE_MESSAGE);
        }
    }

    public static void isDividedByThousand(int value) {
        if (value == 0 || value % ONE_LOTTO != 0) {
            System.out.println(ERROR_MESSAGE + INVALID_MONEY_MESSAGE);
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_MONEY_MESSAGE);
        }
    }

    public static void validateMoneyInput(String moneyInput) {
        isNumberType(moneyInput);
        int money = Integer.parseInt(moneyInput);
        isDividedByThousand(money);
    }
}