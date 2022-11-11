package controller;

import View.GameScreenView;
import camp.nextstep.edu.missionutils.Console;

public class InputController {
    public int inputMoney() {
        while (true) {
            try {
                GameScreenView.pushPurchasingMoney();
                String purchasingMoney = Console.readLine();
            } catch(IllegalArgumentException e) {
                
            }
        }
    }
}
