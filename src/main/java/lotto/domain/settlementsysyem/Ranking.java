package lotto.domain.settlementsysyem;

import java.util.Arrays;
import java.util.List;

public enum Ranking {
    NOT_WINNING(0, List.of()),
    FIFTH_WINNING(5, List.of(new Score(2, 1), new Score(3, 0))),
    FOURTH_WINNING(4, List.of(new Score(3, 1), new Score(4, 0))),
    THIRD_WINNING(3, List.of(new Score(4, 1), new Score(5, 0))),
    SECOND_WINNING(2, List.of(new Score(5, 1))),
    FIRST_WINNING(1, List.of(new Score(6, 0)));

    private final Integer rank;
    private final List<Score> score;

    Ranking(final Integer rank, final List<Score> score) {
        this.rank = rank;
        this.score = score;
    }

    public static Ranking calculateScore(Score score) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.score.contains(score))
                .findAny()
                .orElse(NOT_WINNING);
    }
}
