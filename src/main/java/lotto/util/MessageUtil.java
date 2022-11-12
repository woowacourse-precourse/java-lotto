package lotto.util;

import lotto.constant.ErrorOutputMessage;
import lotto.constant.InputMessage;
import lotto.constant.OutputMessage;


public class MessageUtil {

    public void printPurchaseInput() {
        System.out.println(InputMessage.PURCHASE.getMessage());
    }

    public void printWinningInput() {
        System.out.println(InputMessage.WINNING.getMessage());
    }

    public void printBonusInput() {
        System.out.println(InputMessage.BONUS.getMessage());
    }

    public void printPurchaseError() {
        System.out.println(ErrorOutputMessage.PURCHASE);
    }

    public void printWinningTypeError() {
        System.out.println(ErrorOutputMessage.WINNING_TYPE);
    }

    public void printWinningDuplicateError() {
        System.out.println(ErrorOutputMessage.WINNING_DUPLICATE);
    }

    public void printLottoNumError() {
        System.out.println(ErrorOutputMessage.LOTTO_NUM);
    }

    public void printPurchaseCount() {
        System.out.println(OutputMessage.PURCHASE_COUNT.getMessage());
    }

    public void printWinningStats() {
        System.out.println(OutputMessage.WINNING_STATS.getMessage());
    }

    public void printWinningStatsResult(int matchCount, int amount, int lottoCount) {
        System.out.printf(OutputMessage.WINNING_STATS_RESULT.getMessage(), matchCount, amount, lottoCount);
    }

    public void printEarningRate(Double rate) {
        System.out.printf(OutputMessage.EARNING_RATE.getMessage(), rate);
    }
}
