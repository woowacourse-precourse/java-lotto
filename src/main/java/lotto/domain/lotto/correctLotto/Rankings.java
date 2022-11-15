package lotto.domain.lotto.correctLotto;

import java.util.List;

public class Rankings {

    private final List<Ranking> rankings;

    public Rankings(List<Ranking> ranking) {
        this.rankings = ranking;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

}
