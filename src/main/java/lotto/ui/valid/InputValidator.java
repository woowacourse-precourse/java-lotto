package lotto.ui.valid;

import lotto.controller.LottoIssuer;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum InputValidator {
    INSTANCE;
    private static final String MONEY_ERROR_MESSAGE = "[ERROR] 1000원 단위의 금액을 입력해야 합니다 (최대 금액 2,147,483,000원).";
    private static final String JACKPOT_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45사이의 중복되지 않은 숫자 6개여야 합니다.";
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

        Lotto.validate(jackpotNumbers);

        return jackpotNumbers;
    }

    public static int getValidBonusNumber(String bonusInput) throws IllegalArgumentException {
        if (isParsableInt(bonusInput)) {
            int bonusNumber = Integer.parseInt(bonusInput);
            if (isInLottoRange(bonusNumber)) {
                return bonusNumber;
            }
        }

        throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR_MESSAGE);
    }

    private static boolean isParsableInt(String userInput) {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void validateAllParsable(String jackpotInput) throws IllegalArgumentException {
        boolean allParsable = Arrays.stream(jackpotInput.split(JACKPOT_INPUT_SEPARATOR))
                .allMatch(InputValidator::isParsableInt);

        if (!allParsable) {
            throw new IllegalArgumentException(JACKPOT_ERROR_MESSAGE);
        }
    }

    private static boolean isInLottoRange(int lottoNumber) {
        return (lottoNumber >= Lotto.MIN_NUMBER) && (lottoNumber <= Lotto.MAX_NUMBER);
    }
}
