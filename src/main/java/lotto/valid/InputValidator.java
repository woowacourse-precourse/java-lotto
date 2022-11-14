package lotto.valid;

import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;

public enum InputValidator {
    INSTANCE;
    private static final String NOT_NATURAL_NUMBER_ERROR_MESSAGE = "[ERROR] 0이상의 정수를 입력해야 합니다.";
    private static final String MONEY_ERROR_MESSAGE = "[ERROR] 1000원 단위의 금액을 입력해야 합니다.";
    private static final String NON_DIGIT = "\\D";
    private static final String JACKPOT_NUMBER_INPUT_FORMAT = "(\\d+),(\\d+),(\\d+),(\\d+),(\\d+),(\\d+)";
    private static final String JACKPOT_NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 올바른 형식으로 입력해야 합니다.";
    private static final String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1부터 45사이의 숫자여야 합니다.";

    public static int getValidMoney(String moneyInput) throws IllegalArgumentException {
        if (isParsableInt(moneyInput)) {
            int money = Integer.parseInt(moneyInput);
            if (money >= 0 && money % LottoIssuer.MONEY_UNIT == 0) {
                return money;
            }
        }
        throw new IllegalArgumentException(MONEY_ERROR_MESSAGE);
    }

    private static boolean isParsableInt(String userInput) {
        return (userInput.length() > 0) && !userInput.matches(NON_DIGIT);
    }

    public static void validateJackpotNumberFormat(String jackpotNumberInput) {
        if (!jackpotNumberInput.matches(JACKPOT_NUMBER_INPUT_FORMAT)) {
            throw new IllegalArgumentException(JACKPOT_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void validateBonusNumber(String bonusNumberInput) {
        checkNonDigit(bonusNumberInput);
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        if (bonusNumber < Lotto.MIN_NUMBER || bonusNumber > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private static void checkNonDigit(String string) {
        if (string.matches(NON_DIGIT)) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_ERROR_MESSAGE);
        }
    }

}
