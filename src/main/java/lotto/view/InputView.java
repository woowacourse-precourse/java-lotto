package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.message.ExceptionMessage;
import lotto.view.message.MessagePrinter;

public class InputView {
    public Integer askPrice() {
        MessagePrinter.printAskPriceMessage();
        String inputValue = Console.readLine();
        return validateValue(inputValue);
    }

    public Integer validateValue(String inputValue) {
        if (!isNumber(inputValue)) {
            System.out.println(ExceptionMessage.NON_NUMERIC_VALUE.getMessage());
            throw new IllegalArgumentException();
        }
        return Integer.valueOf(inputValue);
    }

    private boolean isNumber(String inputValue) {
        return inputValue.chars().allMatch(Character::isDigit);
    }
}
