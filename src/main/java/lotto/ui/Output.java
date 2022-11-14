package lotto.ui;

import lotto.Result;
import lotto.Result.MatchCase;
import lotto.Lotto;
import java.text.NumberFormat;

public class Output {
    public void printNumberOfPurchase(int numberOfPurchase) {
        System.out.println(String.format(Messages.NUMBER_OF_PURCHASE.getMessage(), numberOfPurchase));
    }

    public void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public void printResult(Result result) {
        printResultTitle();
        for (MatchCase matchCase : MatchCase.values()) {
            printWinningCount(matchCase, result.getNumberOfMatchCount(matchCase.getMatchCount()));
        }
    }

    public void printBlankLine() {
        System.out.println();
    }

    private void printResultTitle() {
        System.out.println(Messages.WINNING_STATISTICS.getMessage());
    }

    private void printWinningCount(MatchCase matchCase, int count) {
        String commaFormattedPrize = NumberFormat.getInstance().format(matchCase.getPrize());
        String message = Messages.WINNING_COUNT.getMessage();
        if (isBonusMatch(matchCase)) {
            message = Messages.WINNING_COUNT_FOR_BONUS.getMessage();
            System.out.println(String.format(message, commaFormattedPrize, count));
            return;
        }
        System.out.println(String.format(message, matchCase.getMatchCount(), commaFormattedPrize, count));
    }

    private boolean isBonusMatch(MatchCase matchCase) {
        return matchCase.getMatchCount() == MatchCase.MATCH_FIVE_WITH_BONUS.getMatchCount();
    }

    public void printStatics(double prizePerPurchaseAmount) {
        System.out.println(String.format(Messages.RATE_OF_RETURN.getMessage(), prizePerPurchaseAmount));
    }

}
