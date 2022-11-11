package lotto.view;

import static lotto.constant.PrizeType.FIVE_MATCHES_WITHOUT_BONUS_PRIZE;
import static lotto.constant.PrizeType.FIVE_MATCHES_WITH_BONUS_PRIZE;
import static lotto.constant.PrizeType.FOUR_MATCHES_PRIZE;
import static lotto.constant.PrizeType.SIX_MATCHES_PRIZE;
import static lotto.constant.PrizeType.THREE_MATCHES_PRIZE;
import static lotto.constant.MatchType.FIVE_MATCHES_WITHOUT_BONUS;
import static lotto.constant.MatchType.FIVE_MATCHES_WITH_BONUS;
import static lotto.constant.MatchType.FOUR_MATCHES;
import static lotto.constant.MatchType.SIX_MATCHES;
import static lotto.constant.MatchType.THREE_MATCHES;
import static lotto.constant.SystemMessage.EARNINGS_RATE_NOTIFICATION;
import static lotto.constant.SystemMessage.ENTER_BONUS_NUMBER;
import static lotto.constant.SystemMessage.ENTER_PURCHASE_COST;
import static lotto.constant.SystemMessage.ENTER_WINNING_NUMBERS;
import static lotto.constant.SystemMessage.ERROR_PREFIX;
import static lotto.constant.SystemMessage.PURCHASE_COUNT_NOTIFICATION;
import static lotto.constant.SystemMessage.WINNING_STATISTICS;
import static lotto.constant.SystemValue.FIVE_MATCHES_WITHOUT_BONUS_INDEX;
import static lotto.constant.SystemValue.FIVE_MATCHES_WITH_BONUS_INDEX;
import static lotto.constant.SystemValue.FOUR_MATCHES_INDEX;
import static lotto.constant.SystemValue.SIX_MATCHES_INDEX;
import static lotto.constant.SystemValue.THREE_MATCHES_INDEX;

import java.util.List;

public class Output {

    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public static void printWinningStatistics(List<Integer> matchResults) {
        System.out.printf(THREE_MATCHES.printMessage(matchResults.get(THREE_MATCHES_INDEX)),
                THREE_MATCHES_PRIZE.getPrize());
        System.out.printf(FOUR_MATCHES.printMessage(matchResults.get(FOUR_MATCHES_INDEX)),
                FOUR_MATCHES_PRIZE.getPrize());
        System.out.printf(FIVE_MATCHES_WITHOUT_BONUS.printMessage(matchResults.get(FIVE_MATCHES_WITHOUT_BONUS_INDEX)),
                FIVE_MATCHES_WITHOUT_BONUS_PRIZE.getPrize());
        System.out.printf(FIVE_MATCHES_WITH_BONUS.printMessage(matchResults.get(FIVE_MATCHES_WITH_BONUS_INDEX)),
                FIVE_MATCHES_WITH_BONUS_PRIZE.getPrize());
        System.out.printf(SIX_MATCHES.printMessage(matchResults.get(SIX_MATCHES_INDEX)),
                SIX_MATCHES_PRIZE.getPrize());
    }

    public static void printLotteryNumbers(List<Integer> lotteryNumbers) {
        System.out.println(lotteryNumbers.toString());
    }

    public static void enterPurchaseCost() {
        System.out.println(ENTER_PURCHASE_COST);
    }

    public static void purchaseCountNotification(int purchaseCount) {
        System.out.printf(PURCHASE_COUNT_NOTIFICATION, purchaseCount);
    }

    public static void enterWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBERS);
    }

    public static void enterBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER);
    }

    public static void winningStatistics() {
        System.out.println(WINNING_STATISTICS);
    }

    public static void earningsRateNotification(double earningsRate) {
        System.out.printf(EARNINGS_RATE_NOTIFICATION, earningsRate);
    }
}
