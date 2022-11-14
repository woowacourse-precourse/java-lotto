package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Check;
import lotto.domain.Service;
import lotto.util.Constant;

public class Output {
    public static void gameStart() {
        System.out.println(Constant.GAMESTART);
    }

    public static void countLotto(String payMoney) {
        System.out.println(Check.countBuyLotto(payMoney) + Constant.COUNTBUYLOTTO);
    }

    public static void informationOnPurchasedLottoNumbers(List<List<Integer>> purchasedLotto) {
        for (List<Integer> lotto : purchasedLotto) {
            System.out.println(lotto);
        }
    }
}
