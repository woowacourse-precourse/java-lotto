package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.Message;

public class Purchase {
    public int money;

    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        int parseInput = 0;
        try {
            if (isNumber(userInput)) {
                parseInput = Integer.parseInt(userInput);
            }
            if (isValid(parseInput)) {
                this.money = parseInput;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    public boolean isNumber(String userInput) {
        if (!userInput.matches("[-+]?\\d*\\.?\\d+")) {
            throw new IllegalArgumentException(Message.MONEY_ERROR);
        }
        return true;
    }

    public boolean isValid(int userInput) {
        if (userInput % 1000 != 0) {
            throw new IllegalArgumentException(Message.MONEY_ERROR);
        }
        return userInput % 1000 == 0;
    }

    public int canBuyLotto(int money) {
        return money / 1000;
    }
}
