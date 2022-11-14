package lotto.model;

public class Score {
    private final int matchLotto;
    private final int matchBonus;

    public static Score of(int matchLotto, int matchBonus) {
        return new Score(matchLotto, matchBonus);
    }

    public Score(int matchLotto, int matchBonus) {
        this.matchLotto = matchLotto;
        this.matchBonus = matchBonus;
    }

    public boolean hasBonusNumber() {
        return this.matchLotto > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Score score = (Score) o;

        return (this.matchLotto == score.matchLotto
                && this.matchBonus == score.matchBonus);
    }

    @Override
    public int hashCode() {
        int result = this.matchLotto;
        result = 31 * result + this.matchBonus;

        return result;
    }
}
