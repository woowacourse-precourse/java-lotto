package lotto.domain.score;

import java.util.List;

public enum RankingScore {
    NOTING(List.of(new Score(0, 0))),
    FIFTH_SCORE(List.of(new Score(2, 1), new Score(3, 0))),
    FOURTH_SCORE(List.of(new Score(3, 1), new Score(4, 0))),
    THIRD_SCORE(List.of(new Score(4, 1), new Score(5, 0))),
    SECOND_SCORE(List.of(new Score(5, 1))),
    FIRST_SCORE(List.of(new Score(6, 0)));

    private final List<Score> scores;

    RankingScore(final List<Score> scores) {
        this.scores = scores;
    }

    public boolean contains(Score score) {
        return this.scores.contains(score);
    }

    public String resultMatch() {
        return scores.get(0).resultMatchCount();
    }
}
