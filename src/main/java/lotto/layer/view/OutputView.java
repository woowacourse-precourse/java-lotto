package lotto.layer.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView extends View {

    private static final String COMPLETE_BUY_LOTTO = "%d개를 구매했습니다.";
    private static final String STATISTICS = "당첨 통계";
    private static final String THREE_DOT_LINE = "---";
    private static final String RANK_INFO = "%d개 일치 (%s원) - %d개";
    private static final String RANK_BONUS_INFO = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String BENEFIT_RATE = "총 수익률은 %.1f%%입니다.";

    public void responseBuyLotto(List<Lotto> lotteries) {
        int size = lotteries.size();
        print(String.format(COMPLETE_BUY_LOTTO, size));
        for (Lotto lotto : lotteries) {
            print(lotto.toString());
        }
        printEmptyLine();
    }

    public void responseStatistic(Map<Rank, Integer> frequency, double benefitRate) {
        print(STATISTICS);
        print(THREE_DOT_LINE);
        for (Entry<Rank, Integer> rankEntry : frequency.entrySet()) {
            printRankInfo(rankEntry);
        }
        print(String.format(BENEFIT_RATE, benefitRate));
    }

    private void printRankInfo(Entry<Rank, Integer> rankEntry) {
        Rank rank = rankEntry.getKey();
        int count = rankEntry.getValue();
        int commonMatch = rank.getCommonMatch();
        String moneyFormat = rank.getMoneyFormat();
        if (rank.equals(Rank.PLACE_2)) {
            print(String.format(RANK_BONUS_INFO, commonMatch, moneyFormat, count));
            return;
        }
        print(String.format(RANK_INFO, commonMatch, moneyFormat, count));
    }
}
