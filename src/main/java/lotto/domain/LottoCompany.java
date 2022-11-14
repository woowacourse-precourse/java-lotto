package lotto.domain;

import lotto.util.LottoRank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCompany {
    private static final int PERCENTAGE = 100;

    public WinningNumber generateWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumber(winningNumbers, bonusNumber);
    }

    public double getRateOfReturn(int money, int prizeMoney) {
        return ((double) prizeMoney / money) * PERCENTAGE;
    }

    public int getTotalPrizeMoney(List<LottoRank> ranks) {
        return ranks.stream()
                .mapToInt(LottoRank::getPrizeMoney)
                .sum();
    }

    public Map<LottoRank, Integer> getRankCount(List<LottoRank> ranks) {
        Map<LottoRank, Integer> rankCount = new HashMap<>();
        ranks.forEach(lottoRank -> rankCount.put(lottoRank, rankCount.getOrDefault(lottoRank, 0) + 1));
        return rankCount;
    }
}
