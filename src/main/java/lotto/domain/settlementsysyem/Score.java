package lotto.domain.settlementsysyem;

import java.util.Objects;

public class Score {
    private final Integer normal;
    private final Integer bonus;

    protected Score(final Integer normal, final Integer bonus) {
        this.normal = normal;
        this.bonus = bonus;
    }

    public static Score generateEmptyScore() {
        return new Score(0, 0);
    }

    public Integer getNormal() {
        return normal;
    }

    public Integer getBonus() {
        return bonus;
    }

    public Ranking generateRank() {
        return Ranking.calculateScore(this);
    }

    public Score plusNormal() {
        return new Score(this.normal + 1, this.bonus);
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
        return Objects.equals(getNormal(), score.getNormal()) && Objects.equals(getBonus(),
                score.getBonus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNormal(), getBonus());
    }

    public Score plusBonus() {
        return new Score(this.normal, this.bonus + 1);
    }
}
