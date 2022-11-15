package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Statistics;
import lotto.enums.OutputConstants;

public class OutputView {

    public static void printMoneyInputMessage() {
        System.out.println(OutputConstants.INPUT_MONEY_MESSAGE.getValue());
    }

    public static void printInputMoneyResultMessage(int lottoAmount) {
        System.out.println(lottoAmount + OutputConstants.INPUT_MONEY_RESULT_MESSAGE.getValue());
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println(OutputConstants.INPUT_WINNING_NUMBER_MESSAGE.getValue());
    }

    public static void printBonusNumberInputMessage() {
        System.out.println(OutputConstants.INPUT_BONUS_NUMBER_MESSAGE.getValue());
    }

    public static void printWinningStatistics(Statistics statistics) {
        Map<Integer, Integer> ranking = statistics.getRanking();
        List<String> rankMessage = List.of(OutputConstants.DUMMY_MESSAGE.getValue(),
                OutputConstants.RANK_FIRST_MESSAGE.getValue(), OutputConstants.RANK_SECOND_MESSAGE.getValue(),
                OutputConstants.RANK_THIRD_MESSAGE.getValue(), OutputConstants.RANK_FOURTH_MESSAGE.getValue(),
                OutputConstants.RANK_FIFTH_MESSAGE.getValue());
        System.out.println(OutputConstants.STATISTICS_MESSAGE.getValue());
        for (int rank = 5; rank > 0; rank--) {
            System.out.println(
                    rankMessage.get(rank) + ranking.get(rank) + OutputConstants.STATISTICS_END_MESSAGE.getValue());
        }
        System.out.println(OutputConstants.YIELD_START_MESSAGE.getValue() + statistics.getYield()
                + OutputConstants.YIELD_END_MESSAGE.getValue());
    }
}