package lotto;

import java.util.HashMap;
import java.util.List;
import lotto.Constants.PRINT;
import lotto.domain.Buyer;
import lotto.domain.Generator;

public class Display {
    private Display() {
    }

    public static void inputPayment() {
        System.out.println(PRINT.INPUT_PAYMENT);
    }

    public static void lineChange() {
        System.out.println();
    }

    public static void paidAmout(int numbersOfLotto) {
        System.out.println(numbersOfLotto + PRINT.PAID_LOTTO);
    }

    public static void inputWinningNumbers() {
        System.out.println(PRINT.INPUT_WINNING_NUMBERS);
    }

    public static void inputBonusNumber() {
        System.out.println(PRINT.INPUT_BONUS_NUMBER);
    }

    private static void print2ndRankCount(Ranking rank, int rankCount) {
        System.out.printf(
                PRINT.SECOND_RANK_FORMAT,
                rank.getWinningCount(),
                rank.getPrizeLabel(),
                rankCount
        );
    }

    private static void printRankCountExcept2nd(Ranking rank, int rankCount) {
        System.out.printf(
                PRINT.OTHER_RANK_FORMAT,
                rank.getWinningCount(), rank.getPrizeLabel(),
                rankCount
        );
    }

    public static void winningResults(Buyer buyer) {
        System.out.println(PRINT.WINNING_RESULTS);
        List<Ranking> rankings = Ranking.getAll();
        HashMap<String, Integer> winningSummary = buyer.getWinningSummary();
        rankings.stream()
                .forEach(rank -> {
                    int rankCount = winningSummary.get(rank.getLabel());
                    buyer.setTotalWinningPrize(rank.getPrize() * rankCount);
                    if (rank.getLabel().equals(Ranking.SECOND.getLabel())) {
                        print2ndRankCount(rank, rankCount);
                        return;
                    }
                    printRankCountExcept2nd(rank, rankCount);
                });
    }

    public static void profitResult(Buyer buyer) {
        double totalPrize = Generator.calculateProfit(
                buyer.getPayment(), buyer.getTotalWinningPrize());
        System.out.printf(PRINT.PROFIT_FORMAT, totalPrize);
    }

    public static void lottoNumbers(List<Integer> lotto) {
        System.out.println(lotto);
    }
}
