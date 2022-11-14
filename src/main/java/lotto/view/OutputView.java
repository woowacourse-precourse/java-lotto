package lotto.view;

import lotto.domain.LottoMachine;
import lotto.domain.Rank;

import java.util.List;

public class OutputView {

    public static final String BUY_RESULT_MESSAGE = "개를 구매했습니다.";
    public static final String STATISTIC_RESULT_MESSAGE = "당첨 통계";
    public static final String LINE_CHANGE_MESSAGE = "---";

    public static void showLottos(LottoMachine lottoMachine) {
        System.out.println(lottoMachine.getCount() + BUY_RESULT_MESSAGE);
        lottoMachine.getLottos().stream()
                .forEach(lotto -> System.out.println(lotto));
    }

    public static void showGameResult(List<Rank> results, int inputMoney) {
        System.out.println(STATISTIC_RESULT_MESSAGE);
        System.out.println(LINE_CHANGE_MESSAGE);

        for (Rank rank : Rank.getValidRanks()) {
            System.out.println(rank.getMessage() + rank.calculateCount(results) + "개");
        }

        System.out.println("총 수익률은 " + String.format("%.1f", getEarningRate(Rank.calculateEarning(results), inputMoney)) + "%입니다.");
    }

    private static double getEarningRate(int profit, int inputMoney) {
        return (double) (profit * 100) / inputMoney;
    }
}
