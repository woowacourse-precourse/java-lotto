package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int PERCENTAGE_CONVERTER = 100;
    private static final int NO_AMOUNT = 0;
    private static final int DEFAULT_COUNT = 0;
    private static final int ADD_COUNT = 1;

    private final Map<Rank, Integer> lottoResult;

    private LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        lottoResult = createEmptyResult();
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.getResult(lotto);
            lottoResult.put(rank, lottoResult.getOrDefault(rank, DEFAULT_COUNT) + ADD_COUNT);
        }
    }

    private Map<Rank, Integer> createEmptyResult() {
        Map<Rank, Integer> emptyResult = new HashMap<>();
        for (Rank rank : Rank.values()) {
            emptyResult.put(rank, DEFAULT_COUNT);
        }
        return emptyResult;
    }

    public static LottoResult of(List<Lotto> lottos, WinningLotto winningLotto) {
        return new LottoResult(lottos, winningLotto);
    }

    public double calculateProfitRate() {
        int winningAmount = calculateWinningAmount();
        int payment = getPayment();

        return (double) winningAmount / payment * PERCENTAGE_CONVERTER;
    }

    private int getPayment() {
        return calculateQuantity() * Lotto.PRICE;
    }

    private int calculateQuantity() {
        return lottoResult.values().stream()
                .mapToInt(countOfWin -> countOfWin)
                .sum();
    }

    private int calculateWinningAmount() {
        int winningAmount = NO_AMOUNT;
        for (Rank rank : lottoResult.keySet()) {
            Integer countOfWin = lottoResult.get(rank);
            winningAmount += countOfWin * rank.getWinningMoney();
        }
        return winningAmount;
    }

    public int winningCountsOf(Rank rank) {
        return lottoResult.get(rank);
    }
}
