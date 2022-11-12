package lotto.domain;

import lotto.exception.InvalidInputException;

public class Money {
    private static final String NO_NUMBER_EXCEPTION_MESSAGE = "숫자가 아닌 입력 또는 입력범위를 초과 했습니다.";
    private static final String MINUS_NUMBER_EXCEPTION_MESSAGE = "마이너스 금액으로 구매가 불가능합니다.";
    private static final String START_ZERO_EXCEPTION_MESSAGE = "0원빼고 0으로 시작하는 돈은 없습니다.";
    private static final String START_ZERO_REGEX = "^0[0-9]+";
    private static final String NOT_DIVIDE_PRICE_EXCEPTION_MESSAGE = "%d원 단위의 금액을 입력 해야합니다.";
    private static final int PRICE = 1000;
    private final int money;
    private final int lottoAmount;

    public Money(String input) {
        validate(input);
        this.money = Integer.parseInt(input);
        this.lottoAmount = calculateLottoAmount(money);
    }

    public void validate(String input) {
        int money = validateNumber(input);
        validateFrontZeroNumber(input);
        validatePlusNumber(money);
        validateDividedPrice(money);
    }

    private int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(NO_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void validateFrontZeroNumber(String input) {
        if (input.matches(START_ZERO_REGEX))
            throw new InvalidInputException(START_ZERO_EXCEPTION_MESSAGE);
    }

    private void validatePlusNumber(int money) {
        if (money < 0)
            throw new InvalidInputException(MINUS_NUMBER_EXCEPTION_MESSAGE);
    }

    private void validateDividedPrice(int money) {
        if ((money % PRICE) != 0)
            throw new InvalidInputException(String.format(NOT_DIVIDE_PRICE_EXCEPTION_MESSAGE, PRICE));
    }

    private int calculateLottoAmount(int money) {
        return (money / PRICE);
    }

    public int getLottoAmount() {
        return lottoAmount;
    }
}
