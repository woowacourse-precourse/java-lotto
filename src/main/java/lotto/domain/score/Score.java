package lotto.domain.score;

import java.util.Objects;

public class Score {
    private final Integer normal;
    private final Integer bonus;

    public Score(final Integer normal, final Integer bonus) {
        this.normal = normal;
        this.bonus = bonus;
    }

    public static Score generateEmptyScore() {
        return new Score(0, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Score score = (Score) o;
        return Objects.equals(normal, score.normal) && Objects.equals(bonus, score.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(normal, bonus);
    }

    public Ranking generateRank() {
        return Ranking.calculateScore(this);
    }

    public Score plusNormal() {
        return new Score(this.normal + 1, this.bonus);
    }


    public Score plusBonus() {
        return new Score(this.normal, this.bonus + 1);
    }
}
