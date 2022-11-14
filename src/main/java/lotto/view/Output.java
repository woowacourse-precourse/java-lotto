package lotto.view;

import static lotto.util.Constant.REQUESTBONUSNUMBKER;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Check;
import lotto.domain.Service;
import lotto.util.Constant;

public class Output {
    public static void gameStart() {
        System.out.println(Constant.GAMESTART);
    }

    public static void informationOnPurchasedLottoNumbers(List<List<Integer>> purchasedLotto) {
        System.out.println(purchasedLotto.size() + Constant.COUNTBUYLOTTO);
        for (List<Integer> lotto : purchasedLotto) {
            System.out.println(lotto);
        }
    }

    public static void requestInputNumber() {
        System.out.println(Constant.REQUESTWINNINGNUMBER);
    }

    public static void informationOnWinningNumber(List<Integer> winningNumbers) {
        System.out.println(winningNumbers);
    }

    public static void requestBonusNumber() {
        System.out.println(REQUESTBONUSNUMBKER);
    }
}
