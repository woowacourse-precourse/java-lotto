package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.Message;

public class Purchase {
    public int money;

    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int userInput = Integer.parseInt(Console.readLine());
        if (isValid(userInput)) {
            this.money = userInput;
        }

    }

    public boolean isValid(int userInput) throws IllegalArgumentException{
        if(userInput % 1000 != 0){
            throw new IllegalArgumentException(Message.MONEY_ERROR);
        }
        return userInput % 1000 == 0;
    }

    public int canBuyLotto(int money) {
        return money / 1000;
    }
}
