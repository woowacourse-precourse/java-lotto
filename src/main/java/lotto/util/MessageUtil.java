package lotto.util;

import static lotto.constant.InputMessage.*;
import static lotto.constant.OutputMessage.*;


public class MessageUtil {

    public void printPurchaseInput() {
        System.out.println(PURCHASE.getMessage());
    }

    public void printWinningInput() {
        System.out.println(WINNING.getMessage());
    }

    public void printBonusInput() {
        System.out.println(BONUS.getMessage());
    }

    public void printPurchaseCount() {
        System.out.println(PURCHASE_COUNT.getMessage());
    }

    public void printWinningStats() {
        System.out.println(WINNING_STATS.getMessage());
    }

    public void printWinningStatsResult(int matchCount, int amount, int lottoCount) {
        System.out.printf(WINNING_STATS_RESULT.getMessage(), matchCount, amount, lottoCount);
    }

    public void printEarningRate(Double rate) {
        System.out.printf(EARNING_RATE.getMessage(), rate);
    }
}
