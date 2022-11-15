package lotto.UI;

import lotto.Lotto;
import lotto.domain.Match;
import lotto.domain.Operation;

import java.text.DecimalFormat;
import java.util.List;

import static lotto.instance.Setting.*;
import static lotto.message.GuideMessage.*;

public class Output {
    public static void getPurchaseAmount() {
        System.out.println(GET_PURCHASE);
    }

    public static void userLottos(List<Lotto> lottos, int purchaseAmount) {
        int buyAmount = Operation.buyAmount(purchaseAmount);
        System.out.println(buyAmount + BUY_AMOUNT);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void getWinningNumbers() {
        System.out.println(GET_WINNING);
    }

    public static void getBonusNumber() {
        System.out.println(GET_BONUS);
    }

    public static void result(double earningRate, Match match) {
        System.out.println(RESULT_INTRO);
        printMoneyFormat("3개 일치", AMOUNT_THREE, match.MATCH_THREE);
        printMoneyFormat("4개 일치", AMOUNT_FOUR, match.MATCH_FOUR);
        printMoneyFormat("5개 일치", AMOUNT_FIVE, match.MATCH_FIVE);
        printMoneyFormat("5개 일치, 보너스 볼 일치", AMOUNT_FIVE_BONUS, match.MATCH_FIVE_BONUS);
        printMoneyFormat("6개 일치", AMOUNT_SIX, match.MATCH_SIX);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningRate);
    }
    private static void printMoneyFormat(String type, int amount, int match){
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.printf(type+" (" + formatter.format(amount) + "원) - %d개\n",  match);
    }
}
