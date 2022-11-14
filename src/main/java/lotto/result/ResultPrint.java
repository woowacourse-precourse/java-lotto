package lotto.result;

import static lotto.result.LottoPrizes.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class ResultPrint {

    public static void printingResult(Map<String, Integer> prizesMap) {
        LottoResult lottoResult = new LottoResult(prizesMap);
        List<LottoPrizes> lottoPrizes = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
        System.out.println("\n당첨 통계\n---");
        for (LottoPrizes lottoPrize : lottoPrizes) {
            int prizesCount = prizesMap.get(lottoPrize.name());
            printPrize(lottoPrize, prizesCount);
        }
        printYield(lottoResult.yield());
    }
    private static void printPrize(LottoPrizes lottoPrizes, int prizesCount) {
        System.out.print(lottoPrizes.getCondition());
        System.out.print("개 일치");
        if (lottoPrizes == SECOND) {
            System.out.print(", 보너스 볼 일치");
        }
        System.out.print(" (");
        printMoneyFormat(lottoPrizes.money());
        System.out.print("원) - ");
        System.out.print(prizesCount);
        System.out.print("개\n");
    }
    private static void printMoneyFormat(double money) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.print(decimalFormat.format((int) money));
    }
    private static void printYield(double yield) {
        System.out.print("총 수익률은 ");
        printYieldFormat(yield);
        System.out.print("입니다.\n");
    }
    private static void printYieldFormat(double yield) {
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.0");
        System.out.print(decimalFormat.format(yield * 100) + "%");
    }
}
