package lotto.view;

import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLottoList(Lotties lotties) {
        String printFormat = String.format("%d개를 구매했습니다.", lotties.getLottiesSize());
        System.out.println(printFormat);

        for (Lotto lotto : lotties.getLotties()) {
            List<Integer> collect = lotto.getNumbers()
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println(collect);
        }
    }


    public static void printWinResult(Map<LottoRank, Integer> winLottoInfo) {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<LottoRank> collect = winLottoInfo.keySet()
                .stream()
                .sorted(Comparator.comparingInt(LottoRank::matchCount))
                .sorted(Comparator.comparingInt(LottoRank::bonusCount))
                .collect(Collectors.toList());

        for (LottoRank rank : collect) {
            String printFormat = String.format("%s - %d개", rank, winLottoInfo.get(rank));
            System.out.println(printFormat);
        }
    }

    public static void printYieldResult(double lottoYield) {
        String printFormat = String.format("총 수익률은 %.1f%%입니다.", lottoYield);
        System.out.println(printFormat);
    }
}
