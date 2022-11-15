package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.MatchResult;
import lotto.model.MatchType;
import lotto.util.LottoMessage;

public class OutputView {
    public static void printQuantity(int quantity) {
        System.out.printf(LottoMessage.QUANTITY.getMessage(), quantity);
    }

    public static void printLotteries(List<Lotto> lotteries) {
        lotteries.forEach(System.out::println);
    }

    public static void printResult(MatchResult matchResult, Double profit) {
        System.out.printf(LottoMessage.WINNING_RESULT.getMessage(),
                matchResult.getResultByMatchType(MatchType.THREE),
                matchResult.getResultByMatchType(MatchType.FOUR),
                matchResult.getResultByMatchType(MatchType.FIVE),
                matchResult.getResultByMatchType(MatchType.FIVE_BONUS),
                matchResult.getResultByMatchType(MatchType.SIX)
        );
        System.out.printf(LottoMessage.PROFIT.getMessage(), String.format("%.1f", profit) + "%");
    }
}
