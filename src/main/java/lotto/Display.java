package lotto;

import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println(numbersOfLotto + PRINT.BUYED_LOTTO);
    }

    public static void inputWinningNumbers() {
        System.out.println(PRINT.INPUT_WINNING_NUMBERS);
    }

    public static void inputBonusNumber() {
        System.out.println(PRINT.INPUT_BONUS_NUMBER);
    }

    private static void countRanking(Buyer buyer) {
        System.out.println(PRINT.WINNING_RESULTS);
        List<Ranking> rankings = Ranking.getAll();
        HashMap<String, Integer> winningSummary = buyer.getWinningSummary();
        rankings.stream()
                .forEach(rank -> {
                    int rankCount = winningSummary.get(rank.getLabel());
                    if (rank.getLabel().equals(Ranking.SECOND.getLabel())) {
                        buyer.setTotalWinningPrize(rank.getPrize() * rankCount);
                        System.out.printf(
                                PRINT.BONUS_CORRECT_FORMAT,
                                rank.getWinningCount(), rank.getPrizeLabel(),
                                rankCount);
                        return;
                    }
                    buyer.setTotalWinningPrize(rank.getPrize() * rankCount);
                    System.out.printf(
                            PRINT.GENERAL_CORRECT_FORMAT,
                            rank.getWinningCount(), rank.getPrizeLabel(),
                            rankCount);
                });
    }

    public static void winningResults(Buyer buyer) {
        countRanking(buyer);
    }

    public static void profitResult(Buyer buyer) {
        double totalPrize = Generator.profitCalculate(
                buyer.getTotalPurchaseAmout(), buyer.getTotalWinningPrize());
        System.out.printf(PRINT.PROFIT_FORMAT, totalPrize);
    }

    public static void lottoNumbers(List<Integer> lotto) {
        System.out.println(lotto);
    }
}
