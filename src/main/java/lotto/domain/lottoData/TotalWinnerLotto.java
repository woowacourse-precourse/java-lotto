package lotto.domain.lottoData;

import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class TotalWinnerLotto {
    private final Map<Rank,Integer> winnerPerRank;

    public TotalWinnerLotto(Map<Rank, Integer> winnerPerRank) {
        this.winnerPerRank = winnerPerRank;
    }

    public Map<Rank, Integer> getWinnerPerRank() {
        return winnerPerRank;
    }
}
