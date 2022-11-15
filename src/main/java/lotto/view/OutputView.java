package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class OutputView {

    public static void printLottos(int ticketCount, List<Lotto> lottos) {
        System.out.println(System.lineSeparator() + ticketCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.get());
        }
    }

    public static void printResult(HashMap<Rank, Integer> result) {
        List<Rank> printOrder = List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        System.out.println(System.lineSeparator() + "당첨 통계" +  System.lineSeparator() + "---");
        for (Rank rank : printOrder) {
            if (rank.equals(Rank.SECOND)) {
                System.out.println(rank.getMatchCount() + "개 일치, 보너스 볼 일치 " + rank.getPrizeForPrint() +
                        " - " + result.get(rank) + "개");
                continue;
            }
            System.out.println(rank.getMatchCount() + "개 일치 " + rank.getPrizeForPrint() +
                    " - " + result.get(rank)  + "개");
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
