package lotto.view;

import java.util.List;

import lotto.domain.earning.Earning;
import lotto.domain.prize.PrizeStatistics;
import lotto.domain.prize.PrizeType;

public class OutputView {
    private static final String TOTAL_EARNING_OUTPUT = "총 수익률은 %.1f%%입니다.\n";

    public void lottosOutput(List<List<Integer>> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void prizeStatisticsOutPut(PrizeStatistics prizeStatistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (PrizeType prizeType : prizeStatistics.getPrizeStatistics().keySet()) {
            if (prizeType.equals(PrizeType.NONE)) {
                continue;
            }

            System.out.printf(prizeType.getPrizeDetails(), prizeStatistics.getCount(prizeType));
        }
    }

    public void earningOutput(Earning earning) {
        System.out.printf(TOTAL_EARNING_OUTPUT, earning.getEarning());
    }
}
