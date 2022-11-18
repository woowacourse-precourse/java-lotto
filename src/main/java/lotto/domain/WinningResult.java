package lotto.domain;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.LottoRank.checkRank;
import static lotto.domain.LottoRank.getWinLottoRanks;

public class WinningResult {
    private final Map<LottoRank, Integer> result;

    public WinningResult() {
        this.result = new HashMap<>();
    }

    public void addCorrectCount(ComparedNumber comparedNumber){
        LottoRank rank = checkRank(comparedNumber);
        if (rank.isWin()) {
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    public int getWinningCount(LottoRank lottoRank) {
        return result.getOrDefault(lottoRank, 0);
    }

    public String getRateOfReturn(int money) {
        int reward = 0;
        for (LottoRank lottoRank : result.keySet()) {
            reward += lottoRank.calculateSubReturn(result.get(lottoRank));
        }
        return String.format("%.1f", (double) reward / money * 100.0);
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (LottoRank lottoRank : getWinLottoRanks()) {
            sentence.append(lottoRank)
                    .append(" - ")
                    .append(result.getOrDefault(lottoRank, 0))
                    .append("개\n");
        }
        return sentence.toString();
    }
}
