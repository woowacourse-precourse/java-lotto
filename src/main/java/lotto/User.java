package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public void inputMoney() {
        String money = Console.readLine();
    }



    public void validateInputNothing(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(Error.INPUT_NOTHING.getMessage());
        }
    }

    public void validateInputBlank(String input) {
        if (input.equals(" ")) {
            throw new IllegalArgumentException(Error.INPUT_BLANK.getMessage());
        }
    }
}
