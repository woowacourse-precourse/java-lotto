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
        System.out.println(lotties.getLottiesSize());

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
                .collect(Collectors.toList());

        for (LottoRank rank : collect) {
            System.out.println(rank + "-" + winLottoInfo.get(rank) + "개");
        }
    }
}
