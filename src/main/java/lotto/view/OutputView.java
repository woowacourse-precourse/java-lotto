package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String BUY_MESSAGE = System.lineSeparator() + "%d개를 구매했습니다." + System.lineSeparator();
    private static final String START_RESULT_MESSAGE = System.lineSeparator() + "당첨 통계" + System.lineSeparator() + "---";
    private static final String PRINT_RESULT_BY_RANK = "%d개 일치 %s - %d개" + System.lineSeparator();
    private static final String PRINT_RESULT_OF_SECOND = "%d개 일치, 보너스 볼 일치 %s - %d개" + System.lineSeparator();
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottos(int ticketCount, List<Lotto> lottos) {
        System.out.printf(BUY_MESSAGE, ticketCount);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.get());
        }
    }

    public static void printResult(HashMap<Rank, Integer> result) {
        List<Rank> printOrder = List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        System.out.println(START_RESULT_MESSAGE);
        for (Rank rank : printOrder) {
            if (rank.equals(Rank.SECOND)) {
                System.out.printf(PRINT_RESULT_OF_SECOND, rank.getMatchCount(), rank.getPrizeForPrint(), result.get(rank));
                continue;
            }
            System.out.printf(PRINT_RESULT_BY_RANK, rank.getMatchCount(), rank.getPrizeForPrint(), result.get(rank));
        }
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}
