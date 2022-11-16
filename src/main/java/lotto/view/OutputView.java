package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.statistics.Rank;
import lotto.domain.statistics.Result;
import lotto.domain.statistics.Yield;

public class OutputView {
    private static final String PURCHASE_INFO = "\n%d개를 구매했습니다.\n";
    private static final String LOTTO_START_SURFACE = "[";
    private static final String LOTTO_END_SURFACE = "]";
    private static final String LOTTO_DELIMITER = ", ";
    private static final int LOTTO_DELETE_INDEX = 2;
    private static final String LOTTO_STATISTICS_MESSAGE = "\n당첨 통계\n---";
    private static final String LOTTO_RESULT_INFO = "%d개 일치 (%s원) - %d개\n";
    private static final String LOTTO_RESULT_SECOND_INFO = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String PROFIT_MESSAGE = "총 수익률은 %s%%입니다.";

    public static void printLottos(Lottos lottos) {
        System.out.printf(PURCHASE_INFO,lottos.get().size());
        for (Lotto lotto : lottos.get()) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder(LOTTO_START_SURFACE);
        for (int number : lotto.get()) {
            sb.append(number).append(LOTTO_DELIMITER);
        }
        sb.delete(sb.length() - LOTTO_DELETE_INDEX, sb.length()).append(LOTTO_END_SURFACE);
        System.out.println(sb);
    }

    public static void printResult(Result result) {
        System.out.println(LOTTO_STATISTICS_MESSAGE);
        for(Rank rank : Rank.values()){
            printRank(rank,result.getRankCount(rank));
        }
    }

    private static void printRank(Rank rank, int rankCount) {
        if(rank.equals(Rank.NOTHING)){
            return;
        }
        if(rank.equals(Rank.SECOND)) {
            System.out.printf(LOTTO_RESULT_SECOND_INFO,rank.getCount(),rank.getPrize(),rankCount);
            return;
        }
        System.out.printf(LOTTO_RESULT_INFO,rank.getCount(),rank.getPrize(),rankCount);

    }

    public static void printYield(Yield yield) {
        System.out.printf(PROFIT_MESSAGE,yield);
    }
}
