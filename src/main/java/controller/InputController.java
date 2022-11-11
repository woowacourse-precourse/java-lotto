package controller;

import View.GameScreenView;
import camp.nextstep.edu.missionutils.Console;

public class InputController {
    public int inputMoney() {
        while (true) {
            try {
                GameScreenView.pushPurchasingMoney();
                String purchasingMoney = Console.readLine();
                int money = Vaildator.isNumber(purchasingMoney);
                Vaildator.isDivideBy1000(money);
                return money;
            } catch(IllegalArgumentException e) {
                GameScreenView.showMoneyError();
            }
        }
    }
}
