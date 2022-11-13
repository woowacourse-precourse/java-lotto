package controller;

import view.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputController {
    public int inputMoney() {
        while (true) {
            try {
                InputView.pushPurchasingMoney();
                String purchasingMoney = Console.readLine();
                int money = Validator.isNumber(purchasingMoney);
                Validator.isDivideBy1000(money);
                return money;
            } catch(IllegalArgumentException e) {
                InputView.showMoneyError();
            }
        }
    }

    public List<Integer> inputWinningNumber() {
        while (true) {
            try {
                InputView.pushWinningNumber();

            }  catch (IllegalArgumentException e) {
                System.out.println();
            }
        }
    }
}
