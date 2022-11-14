package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY_FOR_LOTTOS = "구입금액을 입력해 주세요";
    private static final String MONEY_IS_DIGIT_VALIDATION_EXCEPTION_MESSAGE = "[ERROR] 구입금액은 문자가 아닌 숫자로 입력해 주세요.";
    private static final String MONEY_DIVIDE_LOTTO_PRICE_EXCEPTION_MESSAGE = "[ERROR] 구입금액은 1,000원으로 나누어 떨어져야 합니다.";
    private static final String MONEY_START_NUMBER_IS_NOT_ZERO_EXCEPTION_MESSAGE = "[ERROR] 구입금액의 시작값은 0이 아닌 1-9의 값으로 시작해야 합니다.";
    private static final int LOTTO_PRICE = 1000;
    private static final char ZERO = '0';

    public int inputMoneyForLottos() {
        System.out.println(INPUT_MONEY_FOR_LOTTOS);
        String moneyForLottos = Console.readLine();
        moneyStartLetterIsNotZeroExceptionCheck(moneyForLottos);
        inputMoneyIsDigitValidationExceptionCheck(moneyForLottos);
        inputMoneyDivideLottoPriceExceptionCheck(moneyForLottos);
        return Integer.parseInt(moneyForLottos);
    }

    private void moneyStartLetterIsNotZeroExceptionCheck(String moneyForLottos) {
        if (moneyForLottos.charAt(0) == ZERO) {
            throw new IllegalArgumentException(MONEY_START_NUMBER_IS_NOT_ZERO_EXCEPTION_MESSAGE);
        }
    }

    private boolean numberIsDigitCheck(String number) {
        return number.chars()
                .mapToObj(i -> (char) i)
                .allMatch(Character::isDigit);
    }

    private void inputMoneyDivideLottoPriceExceptionCheck(String moneyForLottos) {
        if (Integer.parseInt(moneyForLottos) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_DIVIDE_LOTTO_PRICE_EXCEPTION_MESSAGE);
        }
    }

    private void inputMoneyIsDigitValidationExceptionCheck(String moneyForLottos) {
        boolean moneyIsDigitCheckResult = moneyIsDigitCheck(moneyForLottos);
        if (!moneyIsDigitCheckResult) {
            throw new IllegalArgumentException(MONEY_IS_DIGIT_VALIDATION_EXCEPTION_MESSAGE);
        }
    }

    private boolean moneyIsDigitCheck(String moneyForLottos) {
        return numberIsDigitCheck(moneyForLottos);
    }
}
