package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGroup;
import lotto.domain.rule.Rank;
import lotto.resource.message.PrintMessage;

import java.text.NumberFormat;

public class OutputView {

    public static void print(String message) {
        System.out.println(message);
    }

    public static void payout() {
        System.out.println(PrintMessage.PAYOUT.getMessage());
    }

    public static void printLottoNumbers(LottoGroup lottoGroup) {
        for (Lotto lotto : lottoGroup.getLottos()) {
            System.out.println(lotto.toString());
        }
    }

    public static void printLottoCount(int count) {
        System.out.println();
        System.out.printf(PrintMessage.LOTTO_COUNT.getMessage() + "\n", count);
    }

    public static void printWinningNumberInput() {
        System.out.println();
        System.out.println(PrintMessage.WINNING_NUMBER.getMessage());
    }

    public static void printBonusNumberInput() {
        System.out.println();
        System.out.println(PrintMessage.BONUS_NUMBER.getMessage());
    }

    public static void printWinningStatisticsTitle() {
        System.out.println();
        System.out.println(PrintMessage.WINNING_STATISTICS.getMessage());
    }

    public static void printWinningStatistics(Rank rank, Integer rankCount) {
        if (rank.hasBonusNumber()) {
            System.out.printf(PrintMessage.STATISTICS_BONUS.getMessage() + "\n",
                    rank.getMatchingCount(),
                    NumberFormat.getNumberInstance().format(rank.getWinnings()),
                    rankCount
            );
            return;
        }
        System.out.printf(PrintMessage.STATISTICS_NONE_BONUS.getMessage() + "\n",
                rank.getMatchingCount(),
                NumberFormat.getNumberInstance().format(rank.getWinnings()),
                rankCount
        );
    }

    public static void printYield(double yield) {
        System.out.printf(PrintMessage.TOTAL_RETURN.getMessage() + "\n", yield);
    }
}
