package domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Ranking, Integer> lottoResult = new EnumMap<>(Ranking.class);
    private final List<Ranking> lottoStatistics;
    private static final int LOTTO_PRICE = 1000;

    public LottoResult(List<Ranking> rankings) {
        init();
        this.lottoStatistics = rankings;
    }

    public Map<Ranking, Integer> getLottoResult() {
        for (Ranking ranking : this.lottoStatistics) {
            lottoResult.put(ranking, lottoResult.getOrDefault(ranking, 0) + 1);
        }
        return lottoResult;
    }

    public double calculateProfit(int lottoTickets) {
        int lottoPurchaseAmount = lottoTickets * LOTTO_PRICE;
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
