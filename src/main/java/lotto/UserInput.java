package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private String userInput;
    private Integer userMoney;

    public Integer getUserInput() {
        userInput = Console.readLine();
        userInputToUserMoney();

        return userMoney;
    }

    private void userInputToUserMoney() {
        userMoney = Integer.parseInt(userInput);
    }
}
