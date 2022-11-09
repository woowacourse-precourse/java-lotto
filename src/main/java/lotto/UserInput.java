package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.Message;

public class UserInput {

    private String userInput;
    private Integer userMoney;

    public Integer getUserInput() {
        userInput = Console.readLine();
        userInputToUserMoney();

        return userMoney;
    }

    private void userInputToUserMoney() {
        try {
            userMoney = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            inputError();
        }
        validate();
    }

    private void validate() {
        if (userMoney % 1000 != 0) {
            inputError();
        }
    }

    private void inputError() {
        Message.ERROR_INPUT.print();
        throw new IllegalArgumentException();
    }
}
