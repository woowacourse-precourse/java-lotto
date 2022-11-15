package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Ranking, Integer> lottoResult = new EnumMap<>(Ranking.class);
    private final List<Ranking> lottoStatistics;
    private static final int LOTTO_PRICE = 1000;

    public LottoResult(List<Ranking> lottoStatistics) {
        init();
        this.lottoStatistics = lottoStatistics;
    }

    public Map<Ranking, Integer> getRanks() {
        for (Ranking ranking : this.lottoStatistics) {
            lottoResult.put(ranking, lottoResult.get(ranking) + 1);
        }
        return lottoResult;
    }

    public double calculateProfit(int numberOfLottoTickets) {
        int lottoPurchaseAmount = numberOfLottoTickets * LOTTO_PRICE;
        double sumOfPrize = 0;
        for (Ranking ranking : lottoResult.keySet()) {
            if (ranking == Ranking.NOTHING) {
                continue;
            }
            sumOfPrize += lottoResult.get(ranking) * ranking.getPrize();
        }
        return (sumOfPrize / lottoPurchaseAmount) * 100;
    }

    private void init() {
        lottoResult.put(Ranking.FIRST, 0);
        lottoResult.put(Ranking.SECOND, 0);
        lottoResult.put(Ranking.THIRD, 0);
        lottoResult.put(Ranking.FOURTH, 0);
        lottoResult.put(Ranking.FIFTH, 0);
        lottoResult.put(Ranking.NOTHING, 0);
    }
}
