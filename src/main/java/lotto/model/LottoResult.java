package lotto.model;

import java.util.List;

public class LottoResult {

    private final List<Rank> ranks;

    public LottoResult(List<Rank> rewards) {
        this.ranks = rewards;
    }

    public List<Rank> getRanks() {
        return ranks;
    }
}
