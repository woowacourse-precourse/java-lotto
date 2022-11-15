package view;

import static util.Constant.*;

import java.text.DecimalFormat;
import lotto.Lottos;
import lotto.Rank;
import lotto.Result;

public class OutputView {

    // 구매한 로또 번호 출력하는 기능
    public static void printPerchasedLottoNumber(int money, Lottos lottos) {
        System.out.printf(PURCHASE_LOTTO_TICKETS_MSG, money / LOTTO_PURCHASE_COST);
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
    }

    // 당첨 결과를 출력하는 기능
    public static void printWinningStats(Result results) {
        System.out.println(WINNING_STATS_MSG);
        DecimalFormat formatter = new DecimalFormat(DECIMAL_FORMAT);
        for (Rank rank : results.getResult().keySet()) {
            if (rank.name().equals(RANK_SECOND)) {
                System.out.printf(WINNING_STATS_RANK_SECOND_MSG, rank.getCorrectCount(),
                    formatter.format(rank.getPrize()), results.getResult().get(rank));
                continue;
            }
            System.out.printf(WINNING_STATS_OTHER_RANK_MSG, rank.getCorrectCount(),
                formatter.format(rank.getPrize()), results.getResult().get(rank));
        }
    }

    // 수익률을 출력하는 기능
    public static void printYield(Result result, int money) {
        System.out.printf(YIELD_MSG, result.calculateYield(money));
    }
}
