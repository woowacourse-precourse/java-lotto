package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

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

        List<LottoRank> collect = winLottoInfo.keySet()
                .stream()
                .sorted(Comparator.comparingInt(LottoRank::matchCount))
                .sorted(Comparator.comparingInt(LottoRank::bonusCount))
                .collect(Collectors.toList());

        for (LottoRank rank : collect) {
            String printFormat = String.format(View.OUTPUT_WIN_RESULT.message(), rank, winLottoInfo.get(rank));
            System.out.println(printFormat);
        }
    }

    public static void printYieldResult(double lottoYield) {
        String printFormat = String.format(View.OUTPUT_TOTAL_YIELD.message(), lottoYield);
        System.out.println(printFormat);
    }
}
