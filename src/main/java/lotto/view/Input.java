package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class Input {

    public Money getMoney() {
        String input = Console.readLine();
        int convertedInput = stringToInt(input);
        return new Money(convertedInput);
    }

    public int stringToInt(String target) {
        return Integer.parseInt(target);
    }
}
