package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.utils.ExceptionType;

public class Input {

    public Money getMoney() {
        String input = Console.readLine();
        int convertedInput = stringToInt(input);
        return new Money(convertedInput);
    }

    public int stringToInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            Output.printErrorAndExit(ExceptionType.IS_NOT_NUMBER.getMessage());
            throw new IllegalArgumentException(ExceptionType.IS_NOT_NUMBER.getMessage());
        }
    }
}
