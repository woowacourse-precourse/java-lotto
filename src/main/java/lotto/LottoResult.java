package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int MINIMUM_LOTTO_AMOUNT = 1000;
    private static final String MINIMUM_STATISTICS_ERROR = "[ERROR] 당첨 통계 카운트가 1미만일 수 없습니다.";

    private final Map<LottoOperator, Integer> result = new EnumMap<>(LottoOperator.class);
    private final List<LottoOperator> statistics;

    public LottoResult(List<LottoOperator> statistics) {
        validate(statistics);
        init();
        this.statistics = statistics;
    }

    public Map<LottoOperator, Integer> matchWinningRank() {
        for (LottoOperator rank : this.statistics) {
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    public double makeYield(int lottoTickets) {
        int lottoAmount = lottoTickets * MINIMUM_LOTTO_AMOUNT;
        double prizeMoney = 0;
        for (LottoOperator lottoOperator : result.keySet()) {
            if (lottoOperator == LottoOperator.NO_LUCK) {
                continue;
            }
            prizeMoney += lottoOperator.getWinningAmount() * result.get(lottoOperator);
        }
        return (prizeMoney / lottoAmount) * 100;
    }

    private void validate(List<LottoOperator> rankCounts) {
        if (rankCounts.size() < 1) {
            throw new IllegalArgumentException(MINIMUM_STATISTICS_ERROR);
        }
    }

    private void init() {
        result.put(LottoOperator.NO_LUCK, 0);
        result.put(LottoOperator.THREE, 0);
        result.put(LottoOperator.FOUR, 0);
        result.put(LottoOperator.FIVE, 0);
        result.put(LottoOperator.FIVE_BONUS, 0);
        result.put(LottoOperator.SIX, 0);
    }
}
