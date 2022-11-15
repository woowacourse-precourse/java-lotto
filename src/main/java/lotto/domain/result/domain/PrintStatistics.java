package lotto.domain.result.domain;

import static lotto.constant.PrintMessage.*;

public class PrintStatistics {

    public PrintStatistics(int myLottoCnt, int[] totalWin, int totalPrize) {
        System.out.println(STATISTICS_IS);
        printResult(totalWin);
        Yield yield = new Yield(myLottoCnt, totalPrize);
        printYield(yield.yield);
    }

    private void printResult(int[] totalWin) {
        System.out.println(Win.FIFTH.winning() + totalWin[4] + COUNTTING_UNIT);
        System.out.println(Win.FOURTH.winning() + totalWin[3] + COUNTTING_UNIT);
        System.out.println(Win.THIRD.winning() + totalWin[2] + COUNTTING_UNIT);
        System.out.println(Win.SECOND.winning() + totalWin[1] + COUNTTING_UNIT);
        System.out.println(Win.FIRST.winning() + totalWin[0] + COUNTTING_UNIT);
    }

    private void printYield(double yield) {
        System.out.println(YIELD_IS + yield + PERCENT);
    }
}
