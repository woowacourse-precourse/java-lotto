package lotto.view;

import lotto.util.Statistic;
import lotto.domain.Buyer;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import static lotto.util.Message.*;

public class View {

    public void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE.getValue());
    }

    public void printLottoCountMessage(long count) {
        System.out.println(count + COUNT_MESSAGE.getValue());
    }

    public void printLottosInfoByBuyer(Lottos lottos) {
        lottos.forEach((lotto) -> System.out.println(lotto.getNumbers()));
    }

    public void printInputWinningMessage() {
        System.out.println(INPUT_WINNING_MESSAGE.getValue());
    }

    public void printInputBonusMessage() {
        System.out.println(INPUT_BONUS_MESSAGE.getValue());
    }

    public void printWinningStatics() {
        System.out.println(WINNING_STATIC_MESSAGE.getValue());
    }

    public void printWinningCount(Rank rank) {
        System.out.printf(SAME_THREE_COUNT_MESSAGE.getValue(), rank.getRanks().get(Statistic.SAME_THREE));
        System.out.printf(SAME_FOUR_COUNT_MESSAGE.getValue(), rank.getRanks().get(Statistic.SAME_FOUR));
        System.out.printf(SAME_FIVE_COUNT_MESSAGE.getValue(), rank.getRanks().get(Statistic.SAME_FIVE));
        System.out.printf(SAME_FIVE_BONUS_COUNT_MESSAGE.getValue(), rank.getRanks().get(Statistic.SAME_FIVE_BONUS));
        System.out.printf(SAME_SIX_COUNT_MESSAGE.getValue(), rank.getRanks().get(Statistic.SAME_SIX));
    }

    public void printRateOfReturn(Buyer buyer, Rank rank) {
        System.out.printf(TOTAL_YIELD_MESSAGE.getValue(), rank.getYield(buyer));
    }
}
