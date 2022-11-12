package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public Integer inputMoney() {
        return validateInputMoney(getInput());
    }

    private static Integer validateInputMoney(String inputMoney) {
        if (!inputMoney.matches("^[0-9]+000$")) {
            throw new IllegalArgumentException();
        }

        return stringToInteger(inputMoney);
    }

    private static Integer stringToInteger(String inputMoney) {
        return Integer.parseInt(inputMoney);
    }

    private static String getInput() {
        try {
            return Console.readLine();
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
    }
}
