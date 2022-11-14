package lotto.domain.lottoData;

import java.util.List;

public class TotalWinnerLotto {
    private final List<Integer> winnerPerRank;

    public TotalWinnerLotto(List<Integer> winnerPerRank) {
        this.winnerPerRank = winnerPerRank;
    }

    public List<Integer> getWinnerPerRank() {
        return winnerPerRank;
    }
}
