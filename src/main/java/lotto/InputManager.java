package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public int inputCustomerMoney() {
        String input = Console.readLine();
        if (!Verifier.isValidMoney(input)) {
            throw new IllegalArgumentException();
        }
        int money = Integer.parseInt(input);

        return money;
    }
}
