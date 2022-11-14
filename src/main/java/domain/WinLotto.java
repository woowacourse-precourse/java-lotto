package domain;

import util.LottoRank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinLotto {

    private final List<Lotto> lotteries;
    private final Lotto winnerNumber;
    private final int bonusNumber;
    private final Map<LottoRank, Integer> result;
    private long profit;

    public WinLotto(List<Lotto> lotteries, Lotto winnerNumber, int bonusNumber) {
        this.lotteries = lotteries;
        this.winnerNumber = winnerNumber;
        this.bonusNumber = bonusNumber;
        this.profit = 0;
        this.result = setResult();
    }

    private Map<LottoRank, Integer> setResult() {
        Map<LottoRank, Integer> numberOfRank = new EnumMap<>(LottoRank.class);
        final int DEFAULT_ZERO = 0;
        final int ONE = 1;

        lotteries.stream().forEach(lotto -> {
            LottoRank rank =
                    LottoRank.getRank(lotto, lotto.numberOfSameNumbers(winnerNumber.getNumbers()), bonusNumber);

            Integer numRank = numberOfRank.getOrDefault(rank, DEFAULT_ZERO);

            if (numRank.equals(DEFAULT_ZERO)) {
                addProfitByWinLotto(rank.getPrizeMoney());
            }

            numberOfRank.put(rank, numRank + ONE);
        });

        return numberOfRank;
    }

    private void addProfitByWinLotto(int money) {
        this.profit += money;
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public long getProfit() {
        return profit;
    }

}
