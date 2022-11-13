package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import lotto.Constants.PRINT;
import lotto.domain.Buyer;
import lotto.domain.Generator;
import lotto.domain.Lotto;

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

    public static void winningResults(Buyer buyer) {
        System.out.println(PRINT.WINNING_RESULTS);
        HashMap<String, Integer> winningSummary = buyer.getWinningSummary();
        List<Ranking> rankings = new ArrayList<Ranking>(
                Arrays.asList(
                        Ranking.FIFTH,
                        Ranking.FOURTH,
                        Ranking.THIRD,
                        Ranking.SECOND,
                        Ranking.FIRST));

        rankings.stream()
                .forEach(rank -> {
                    int rankCount = winningSummary.get(rank.getLabel());
                    if (rank.getLabel().equals(Lotto.RANK_SECOND)) {
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

        double totalPrize = Generator.profitCalculate(
                buyer.getTotalPurchaseAmout(), buyer.getTotalWinningPrize());

        System.out.printf(PRINT.PROFIT_FORMAT, totalPrize);

    }

    public static void lottoNumbers(List<Integer> lotto) {
        System.out.println(lotto);
    }
}
