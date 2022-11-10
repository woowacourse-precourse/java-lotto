package lotto.console;

public class MoneyInput extends Console {
    private final String NO_NUMBER_EXCEPTION_MESSAGE = "숫자가 아닌 입력 또는 입력범위를 초과 했습니다.";
    private final String MINUS_NUMBER_EXCEPTION_MESSAGE = "마이너스 금액으로 구매가 불가능합니다.";
    private final String START_ZERO_EXCEPTION_MESSAGE = "0원빼고 0으로 시작하는 돈은 없습니다.";
    private final String START_ZERO_REGEX = "^0[0-9]+";
    private final String NO_DIVIDE_1000_MONEY_EXCEPTION_MESSAGE = "1000원 단위의 금액을 입력 해야합니다.";

    @Override
    protected void checkInput(String input) {
        isNumber(input);
        isPlusNumber(input);
        isFrontZeroNumber(input);
        isNotDivideThousand(input);
    }

    private void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(NO_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void isPlusNumber(String input){
        if((Integer.parseInt(input)) < 0)
            throw new InvalidInputException(MINUS_NUMBER_EXCEPTION_MESSAGE);
    }

    private void isFrontZeroNumber(String input){
        if(input.matches(START_ZERO_REGEX))
            throw new InvalidInputException(START_ZERO_EXCEPTION_MESSAGE);
    }

    private void isNotDivideThousand(String input) {
        int number = Integer.parseInt(input);
        if ((number % 1000) != 0)
            throw new InvalidInputException(NO_DIVIDE_1000_MONEY_EXCEPTION_MESSAGE);
    }
}
