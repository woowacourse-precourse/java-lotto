package lotto.valid;

import lotto.domain.LottoMachine;

public enum InputValidator {
    INSTANCE;
    private static final String MONEY_ERROR_MESSAGE = "[ERROR] 1000원 단위의 금액을 입력해야 합니다.";

    public static void validateMoney(String moneyInput) {
        int money = convertStringToInteger(moneyInput, MONEY_ERROR_MESSAGE);
        if (money < 0 || money % LottoMachine.MONEY_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_ERROR_MESSAGE);
        }
    }

    private static Integer convertStringToInteger(String string, String errorMessage) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }


}
