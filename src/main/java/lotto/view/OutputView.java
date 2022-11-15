package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.rank.LottoRank;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final DecimalFormat decFormat = new DecimalFormat("###,###");

    public static void printLottoList(List<Lotto> lotties) {
        String printFormat = String.format(View.OUTPUT_LOTTO_ISSUE.message(), lotties.size());
        System.out.println(printFormat);

        for (Lotto lotto : lotties) {
            List<Integer> collect = lotto.getNumbers()
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println(collect);
        }
    }


    public static void printWinResult(Map<LottoRank, Integer> winLottoInfo) {
        System.out.println(View.OUTPUT_STATISTICS.message());
        System.out.println(View.OUTPUT_DOTTED_LINE.message());

        winLottoInfo.keySet()
                .stream()
                .filter(rank -> !rank.equals(LottoRank.FAIL))
                .sorted(Comparator.comparingInt(LottoRank::matchCount))
                .sorted((o1, o2) -> Boolean.compare(o1.isBonusNumber(), o2.isBonusNumber()))
                .forEach(rank -> printResultAccordingToBonus(rank, winLottoInfo.get(rank)));
    }

    private static void printResultAccordingToBonus(LottoRank rank, int totalCount) {
        String winMoney = decFormat.format(rank.winMoney());
        String printFormat = String.format(View.OUTPUT_WIN_RESULT.message(), rank.matchCount(), winMoney, totalCount);

        if (rank.isBonusNumber()) {
            printFormat =  String.format(View.OUTPUT_BONUS_RESULT.message(), rank.matchCount(), winMoney, totalCount);
        }

        System.out.println(printFormat);
    }

    public static void printYieldResult(double lottoYield) {
        String printFormat = String.format(View.OUTPUT_TOTAL_YIELD.message(), lottoYield);
        System.out.println(printFormat);
    }
}
