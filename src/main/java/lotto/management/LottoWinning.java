package lotto.management;

import java.util.Arrays;
import java.util.List;

public class LottoWinning {
    private final int THREE_NUMBERS_AMOUNT = 5000;
    private final int FOUR_NUMBERS_AMOUNT = 50000;
    private final int FIVE_NUMBERS_AMOUNT = 1500000;
    private final int SIX_NUMBERS_AMOUNT = 2000000000;
    private final int FIVE_AND_BONUS_NUMBERS_AMOUNT = 30000000;
    private final List<Integer> winningAmount = Arrays.asList(THREE_NUMBERS_AMOUNT, FOUR_NUMBERS_AMOUNT
            , FIVE_NUMBERS_AMOUNT, SIX_NUMBERS_AMOUNT, FIVE_AND_BONUS_NUMBERS_AMOUNT);

    private final List<Integer> ticketResult;
    private final int purchaseMoney;
    private int totalWinningAmount;

    public LottoWinning(List<Integer> ticketResult, int purchaseMoney) {
        this.ticketResult = ticketResult;
        this.purchaseMoney = purchaseMoney;
        init();
    }

    private void init() {
        totalWinningAmount = 0;
    }

    public double getLottoYield() {
        return (float) getTotalWinningAmount() / (float) purchaseMoney;
    }

    private int getTotalWinningAmount() {
        for (int index = 0; index < ticketResult.size(); index++) {
            totalWinningAmount += winningAmount.get(index) * ticketResult.get(index);
        }
        return totalWinningAmount;
    }
}
