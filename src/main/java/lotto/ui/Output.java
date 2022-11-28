package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

import static lotto.messages.UI_MSG.*;

public class Output {

    public static void printLotteries(List<Lotto> lotteries) {
        System.out.println(String.format(OUTPUT_PURCHASE.getMsg(), lotteries.size()));
        for (Lotto lotto : lotteries) {
            lotto.printLotto();
        }
    }

    public static void printStatistics(Map<Integer, Integer> winningResult, double yield) {
        System.out.println(RANK5.getMsg() + winningResult.get(5) + "개");
        System.out.println(RANK4.getMsg() + winningResult.get(4) + "개");
        System.out.println(RANK3.getMsg() + winningResult.get(3) + "개");
        System.out.println(RANK2.getMsg() + winningResult.get(2) + "개");
        System.out.println(RANK1.getMsg() + winningResult.get(1) + "개");
        System.out.println(String.format(OUTPUT_YIELD.getMsg(), yield * 100));
    }
}
