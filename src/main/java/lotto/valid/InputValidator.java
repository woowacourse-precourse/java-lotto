package lotto.valid;

import lotto.domain.LottoIssuer;

public enum InputValidator {
    INSTANCE;
    private static final String NOT_NATURAL_NUMBER_ERROR_MESSAGE = "[ERROR] 0이상의 정수를 입력해야 합니다.";
    private static final String MONEY_ERROR_MESSAGE = "[ERROR] 1000원 단위의 금액을 입력해야 합니다.";
    private static final String NON_DIGIT = "\\D";
    private static final String JACKPOT_NUMBER_INPUT_FORMAT = "(\\d+),(\\d+),(\\d+),(\\d+),(\\d+),(\\d+)";
    private static final String JACKPOT_NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 올바른 형식으로 입력해야 합니다.";

    public static void validateMoney(String moneyInput) {
        checkNonDigit(moneyInput);
        int money = Integer.parseInt(moneyInput);
        if (money < 0 || money % LottoIssuer.MONEY_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_ERROR_MESSAGE);
        }
    }

    public static void validateJackpotNumberFormat(String jackpotNumberInput) {
        if (!jackpotNumberInput.matches(JACKPOT_NUMBER_INPUT_FORMAT)) {
            throw new IllegalArgumentException(JACKPOT_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }


    private static void checkNonDigit(String string) {
        if (string.matches(NON_DIGIT)) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_ERROR_MESSAGE);
        }
    }

}
