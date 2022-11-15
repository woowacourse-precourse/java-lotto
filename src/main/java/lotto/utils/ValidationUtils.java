package lotto.utils;

import java.util.regex.Pattern;

public class ValidationUtils {
    private static final String NUMBER_REGEX = "^[0-9]+$";
    private static final String WINNING_NUMBER_FORMAT = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$";
    private static final String INPUT_NUMBER_FORMAT = "[ERROR] 양수인 숫자를 입력해주세요.";
    public static final String INPUT_RIGHT_FORMAT = "[ERROR] 콤마(,)로 구분되는 숫자 6개를 입력해 주세요.";
    public static final int LOTTO_PRICE = 1_000;
    public static final String INPUT_LARGER = "원 보다 크게 입력해 주세요.";
    public static final String CANNOT_PURCHASE_LOTTO = "[ERROR] 로또를 1개도 구매할 수 없습니다. ";

    private ValidationUtils() {
    }

    public static void validateMoneyAmount(String moneyAmount) {
        validateNumber(moneyAmount);
        validatePrice(moneyAmount);
    }

    public static void validateWinningNumber(String number) {
        if (isWinningNumberFormat(number)) {
            return;
        }
        throw new IllegalArgumentException(INPUT_RIGHT_FORMAT);
    }

    private static boolean isWinningNumberFormat(String number) {
        number = number.trim();
        return Pattern.matches(WINNING_NUMBER_FORMAT, number);
    }

    public static void validateBonusNumber(String number) {
        validateNumber(number);
    }

    private static void validateNumber(String number) {
        if (isNumber(number)) {
            return;
        }
        throw new IllegalArgumentException(INPUT_NUMBER_FORMAT);
    }

    private static boolean isNumber(String number) {
        return Pattern.matches(NUMBER_REGEX, number);
    }

    private static void validatePrice(String moneyAmount) {
        int money = Integer.parseInt(moneyAmount);
        if (underPurchaseMoney(money)) {
            throw new IllegalArgumentException(CANNOT_PURCHASE_LOTTO + LOTTO_PRICE + INPUT_LARGER);
        }
    }

    private static boolean underPurchaseMoney(int money) {
        return money < LOTTO_PRICE;
    }
}
