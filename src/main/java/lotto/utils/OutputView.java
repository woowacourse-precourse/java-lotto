package lotto.utils;

import lotto.domain.Ranking;

import java.util.List;

import static lotto.constant.Constants.*;

public class OutputView {

    public static void printPurchaseMessage() {
        System.out.println(PURCHASE_MESSAGE);
    }

    public static void printPurchaseConfirmMessage(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + PURCHASE_CONFIRM_MESSAGE);
    }

    public static void printSortedLottoNumber(List<Integer> sortedNumbers) {
        System.out.println(sortedNumbers);
    }

    public static void printLineBreak() {
        System.out.println();

    }
    public static void printWinningNumberMessage() {
        System.out.println(WINNING_NUMBER_MESSAGE);

    }

    public static void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public static void printWinningStatistics(int[] result) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(Ranking.FifthPlace.printMessage(result[5]));
        System.out.println(Ranking.FourthPlace.printMessage(result[4]));
        System.out.println(Ranking.ThirdPlace.printMessage(result[3]));
        System.out.println(Ranking.SecondPlace.printMessage(result[2]));
        System.out.println(Ranking.FirstPlace.printMessage(result[1]));
    }

    public static void printProfitPercent(double profit) {
        System.out.println("총 수익률은 " + String.format("%.1f", profit) + "%입니다.\n");
    }

    public static void printErrorMessage(String errorMessage){
        System.out.println(errorMessage);
    }
}
