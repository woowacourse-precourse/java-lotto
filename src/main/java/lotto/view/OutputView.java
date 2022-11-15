package lotto.view;

import lotto.Lotto;
import lotto.constant.RankInfo;

import java.util.Map;

public class OutputView {

    public static void informNumberPurchases(int numberLottos) {
        System.out.print(numberLottos);
    }

    public static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.get());
    }

    public static void winningStatistic(RankInfo win, Map<Integer, Integer> result, int index) {
        System.out.println(win.message + result.get(index) + "개");
    }

    public static void printTotalPrizeRate(double totalRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", totalRate);
    }
}