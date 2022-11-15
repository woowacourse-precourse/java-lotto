package lotto.view;

import lotto.enums.Rank;
import lotto.model.GenerateLotto;
import lotto.model.Lotto;
import lotto.model.Money;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PURCHASE_OUTPUT = "개를 구매했습니다.";
    private static final String STATISTICS_MESSAGE = "당첨 통계\n" + "---";
    private static final String WINNING_STATISTICS = "%d개 일치 (%,d원) - %d개\n";
    private static final String BONUS_STATISTICS = "5개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String PROFIT_MESSAGE = "총 수익률은 %,.1f%%입니다.";

    public static void lottoTicketsOut(int tickets, List<Lotto> newLotto) {
        System.out.println();
        System.out.println(tickets + PURCHASE_OUTPUT);

        for(Lotto lotto: newLotto) {
            System.out.println(lotto.getLotto());
        }
    }
    public static void printResult(Map<Rank, Integer> ranking, double profit){
        System.out.println();
        System.out.println(STATISTICS_MESSAGE);
        for(Rank rank: Rank.values()) {
            if(rank == Rank.SECOND) {
                System.out.printf((BONUS_STATISTICS), rank.getRank().get(1), ranking.get(rank));
                continue;
            }
            System.out.printf((WINNING_STATISTICS),
                    rank.getRank().get(0), rank.getRank().get(1), ranking.get(rank));
        }
        System.out.printf((PROFIT_MESSAGE) + "%n", profit*100);
    }
}
