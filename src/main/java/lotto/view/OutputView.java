package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningMoney;
import java.util.List;
import java.util.Map;

import static lotto.domain.WinningMoney.*;

public class OutputView {
    private static final String QUANTITY = "%d개를 구매했습니다.\n";
    private static final String TITLE = "당첨 통계";
    private static final String LINE = "---";
    private static final String FIFTH_PLACE = "3개 일치 (5,000원) - %d개\n";
    private static final String FOURTH_PLACE = "4개 일치 (50,000원) - %d개\n";
    private static final String THIRD_PLACE = "5개 일치 (1,500,000원) - %d개\n";
    private static final String SECOND_PLACE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String FIRST_PLACE = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String YIELD = "총 수익률은 %.1f%%입니다.";

    public void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.printf(QUANTITY, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningHistory(Map<WinningMoney, Integer> winningHistory) {
        System.out.println();
        System.out.println(TITLE);
        System.out.println(LINE);
        System.out.printf(FIFTH_PLACE, winningHistory.get(FIVE_THOUSAND));
        System.out.printf(FOURTH_PLACE, winningHistory.get(FIFTY_THOUSAND));
        System.out.printf(THIRD_PLACE, winningHistory.get(ONE_MILLION_AND_A_HALF_MILLION));
        System.out.printf(SECOND_PLACE, winningHistory.get(THIRTY_MILLION));
        System.out.printf(FIRST_PLACE, winningHistory.get(TWO_BILLION));
    }

    public void printYield(double yield) {
        System.out.printf(YIELD, yield);
    }
}
