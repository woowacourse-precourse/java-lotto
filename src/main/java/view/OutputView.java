package view;

import lotto.domain.PurchasedLottos;
import lotto.domain.Rank;
import lotto.domain.Result;

import java.util.Arrays;

import static lotto.constant.Message.*;

public class OutputView {

    public void printPurchasedLottos(int count, PurchasedLottos purchasedLottos) {
        System.out.println(count + PURCHASE_LOTTO_MESSAGE);

        purchasedLottos.getPurchasedLottos()
                .forEach(purchasedLotto -> {
                    System.out.println(
                            Arrays.toString(
                                    purchasedLotto
                                            .getNumbers()
                                            .stream()
                                            .toArray()
                            )
                    );
                });
    }

    public void printResult(Result result, int price) {
        System.out.println(WINNING_STATS_INFO_MESSAGE);

        result.getResult()
                .forEach(OutputView::printResultByNumber);

        System.out.print(
                TOTAL_PROFIT_PERCENT_MESSAGE_1
                        + result.calculateProfit(price) + TOTAL_PROFIT_PERCENT_MESSAGE_2
        );

    }

    private static void printResultByNumber(Rank rank, Integer count) {
        if (rank.getCountOfMatch() == 0) {
            return;
        }

        if (rank.isMatchedBonus()) {
            System.out.println(
                    FIVE_WITH_BONUS_MATCH_MESSAGE + count + "개"
            );
            return;
        }

        System.out.println(
                COUNT_BY_NUMBER_MESSAGE[rank.getCountOfMatch()] + count + "개"
        );
    }
}
