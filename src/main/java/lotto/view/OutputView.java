package lotto.view;

import static lotto.Constants.ASK_BONUS_NUMBER;
import static lotto.Constants.ASK_LOTTO_WINNING_NUMBERS;
import static lotto.Constants.ASK_PURCHASE_AMOUNT;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    public static void printAskPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
    }

    public static void printAskWinningNumbers() {
        System.out.println(ASK_LOTTO_WINNING_NUMBERS);
    }

    public static void printAskBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
    }

    public static void printIssuedLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            System.out.println("[" + lotto.toString() + "]");
        }
    }
}
