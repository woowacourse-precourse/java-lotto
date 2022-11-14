package lotto;

import static lotto.LottoPrizes.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class ResultPrint {

    public static void printingResult(Map<String, Integer> prizesMap) {
        List<LottoPrizes> lottoPrizes = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
        for (LottoPrizes lottoPrize : lottoPrizes) {
            int prizesCount = prizesMap.get(lottoPrize.name());
            printPrize(lottoPrize, prizesCount);
        }
    }
    private static void printPrize(LottoPrizes lottoPrizes, int prizesCount) {
        System.out.print(lottoPrizes.getCondition());
        System.out.print("개 일치");
        if (lottoPrizes == SECOND) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.print(" (");
        printMoneyFormat((int) lottoPrizes.money());
        System.out.print("원) - ");
        System.out.print(prizesCount);
        System.out.print("개\n");
    }
    private static void printMoneyFormat(int money) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.print(decimalFormat.format(money));
    }
}
