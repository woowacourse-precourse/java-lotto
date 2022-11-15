package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.Message;

public class Purchase {
    public int money;

    public void inputMoney() {
        System.out.println(Message.INPUT_MONEY);
        String userInput = Console.readLine();
        try {
            isNumber(userInput);
            int parseInput = Integer.parseInt(userInput);
            isValid(parseInput);
            this.money = parseInput;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void isNumber(String userInput) {
        if (!userInput.matches("[-+]?\\d*\\.?\\d+")) {
            throw new IllegalArgumentException(Message.MONEY_ERROR);
        }
    }

    public void isValid(int userInput) {
        if (userInput % 1000 != 0) {
            throw new IllegalArgumentException(Message.MONEY_ERROR);
        }
    }

    public int canBuyLotto(int money) {
        return money / 1000;
    }
}
