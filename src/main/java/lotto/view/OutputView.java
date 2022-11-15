package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.rank.LottoRank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final DecimalFormat decFormat = new DecimalFormat("###,###");
    private static final long DEFAULT_VALUE = 0L;

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

    public static void printWinResult(Map<LottoRank, Long> winLottoInfo) {
        System.out.println(View.OUTPUT_STATISTICS.message());
        System.out.println(View.OUTPUT_DOTTED_LINE.message());

        fillUnRankedToMap(winLottoInfo);

        winLottoInfo.keySet()
                .stream()
                .filter(rank -> !rank.equals(LottoRank.FAIL))
                .sorted(Comparator.comparingInt(LottoRank::matchCount))
                .sorted((o1, o2) -> Boolean.compare(o1.isBonusNumber(), o2.isBonusNumber()))
                .forEach(rank -> printResultAccordingToBonus(rank, winLottoInfo.get(rank).intValue()));
    }

    private static void fillUnRankedToMap(Map<LottoRank, Long> winLottoInfo) {
        Arrays.stream(LottoRank.values())
                .filter(rank -> !winLottoInfo.containsKey(rank))
                .forEach(rank -> winLottoInfo.put(rank, DEFAULT_VALUE));
    }

    private static void printResultAccordingToBonus(LottoRank rank, int totalCount) {
        String winMoney = decFormat.format(rank.winMoney());
        String printFormat = String.format(selectMessage(rank), rank.matchCount(), winMoney, totalCount);
        System.out.println(printFormat);
    }

    private static String selectMessage(LottoRank rank) {
        if (rank.isBonusNumber()) {
            return View.OUTPUT_BONUS_RESULT.message();
        }
        return View.OUTPUT_WIN_RESULT.message();
    }

    public static void printYieldResult(double lottoYield) {
        String printFormat = String.format(View.OUTPUT_TOTAL_YIELD.message(), lottoYield);
        System.out.println(printFormat);
    }
}
