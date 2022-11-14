package lotto.valid;

import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum InputValidator {
    INSTANCE;
    private static final String NOT_NATURAL_NUMBER_ERROR_MESSAGE = "[ERROR] 0이상의 정수를 입력해야 합니다.";
    private static final String MONEY_ERROR_MESSAGE = "[ERROR] 1000원 단위의 금액을 입력해야 합니다.";
    private static final String JACKPOT_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45사이의 중복되지 않은 숫자 6개여야 합니다.";
    private static final String NON_DIGIT = "\\D";
    private static final String BONUS_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 보너스 번호는 1부터 45사이의 숫자여야 합니다.";

    private static final String JACKPOT_INPUT_SEPARATOR = ",";

    public static int getValidMoney(String moneyInput) throws IllegalArgumentException {
        if (isParsableInt(moneyInput)) {
            int money = Integer.parseInt(moneyInput);
            if (money >= 0 && money % LottoIssuer.MONEY_UNIT == 0) {
                return money;
            }
        }
        throw new IllegalArgumentException(MONEY_ERROR_MESSAGE);
    }

    public static List<Integer> getValidJackpotNumbers(String jackpotInput) throws IllegalArgumentException {
        validateAllParsable(jackpotInput);

        List<Integer> jackpotNumbers =
                Arrays.stream(jackpotInput.split(JACKPOT_INPUT_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        LottoValidator.validate(jackpotNumbers);

        return jackpotNumbers;
    }

    private static void validateAllParsable(String jackpotInput) throws IllegalArgumentException {
        boolean allParsable = Arrays.stream(jackpotInput.split(JACKPOT_INPUT_SEPARATOR))
                .allMatch(InputValidator::isParsableInt);

        if (!allParsable) {
            throw new IllegalArgumentException(JACKPOT_ERROR_MESSAGE);
        }
    }

    private static boolean isParsableInt(String userInput) {
        return (userInput.length() > 0) && !userInput.matches(NON_DIGIT);
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
