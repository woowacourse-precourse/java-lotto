package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private UserInput() {}

    static public long inputMoney() {
        String input = Console.readLine();
        validateMoney(input);
        return Long.parseLong(input);
    }
}
