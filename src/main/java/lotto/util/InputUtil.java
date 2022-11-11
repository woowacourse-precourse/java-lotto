package lotto.util;

import lotto.domain.enums.Message;
import lotto.domain.enums.Number;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputUtil {

    public String getUserInput() {
        String input = readLine();
        return input;
    }

    public void checkValidationMoney(String input) {
        int inputNumber = Integer.parseInt(input);

        if(inputNumber % Number.THOUSAND.getValue() != Number.ZERO.getValue()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(Message.NOT_THOUSAND_UNIT_INPUT_ERROR.getMessage());
            throw illegalArgumentException;
        }
    }

}
