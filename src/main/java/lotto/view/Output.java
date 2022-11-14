package lotto.view;

import static lotto.util.Constant.COUNTBUYLOTTO;
import static lotto.util.Constant.REQUESTBONUSNUMBKER;
import static lotto.util.Constant.REQUESTWINNINGNUMBER;
import static lotto.util.Constant.RESULTOFANNOUNCEMENTBEGIN;

import java.util.List;
import lotto.util.Constant;

public class Output {
    public static void gameStart() {
        System.out.println(Constant.GAMESTART);
    }

    public static void informationOnPurchasedLottoNumbers(List<List<Integer>> purchasedLotto) {
        System.out.println(purchasedLotto.size() + COUNTBUYLOTTO);
        for (List<Integer> lotto : purchasedLotto) {
            System.out.println(lotto);
        }
    }

    public static void requestInputNumber() {
        System.out.println(REQUESTWINNINGNUMBER);
    }

    public static void informationOnWinningNumber(List<Integer> winningNumbers) {
        System.out.println(winningNumbers);
    }

    public static void requestBonusNumber() {
        System.out.println(REQUESTBONUSNUMBKER);
    }

    public static void beginAnnouncementOfResult() {
        System.out.println(RESULTOFANNOUNCEMENTBEGIN);
    }
}
