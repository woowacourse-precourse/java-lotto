package lotto.view;

import lotto.domain.Check;
import lotto.util.Constant;

public class Output {
    public static void gameStart() {
        System.out.println(Constant.GAMESTART);
    }

    public static void countLotto(String payMoney) {
        System.out.println(Check.countBuyLotto(payMoney) + Constant.COUNTBUYLOTTO);
    }
}
