package controller;

import View.InputView;
import camp.nextstep.edu.missionutils.Console;

public class InputController {
    public int inputMoney() {
        while (true) {
            try {
                InputView.pushPurchasingMoney();
                String purchasingMoney = Console.readLine();
                int money = Vaildator.isNumber(purchasingMoney);
                Vaildator.isDivideBy1000(money);
                return money;
            } catch(IllegalArgumentException e) {
                InputView.showMoneyError();
            }
        }
    }
}
