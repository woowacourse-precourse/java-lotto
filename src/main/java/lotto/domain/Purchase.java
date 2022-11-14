package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    int money;

    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int userInput = Integer.parseInt(Console.readLine());
        if (isValid(userInput)) {
            this.money = userInput;
        }

    }

    public boolean isValid(int userInput) {
        return userInput % 1000 == 0;
    }

    public int canBuyLotto(int money) {
        return money / 1000;
    }
}
