package lotto.domain.score;

import java.util.Objects;

public class Score {
    private static final String MESSAGE_NOTHING = "낙첨";
    private static final String MESSAGE_N_AMOUNT_CORRECT = "%d개 일치";
    private static final String MESSAGE_BONUS_CORRECT = ", 보너스 볼 일치";
    private static final Integer MIN_COUNT = 3;
    private static final Integer CHECK_NORMAL_COUNT = 5;
    private static final Integer BONUS_COUNT = 1;
    private final Integer normal;
    private final Integer bonus;


    public Score(final Integer normal, final Integer bonus) {
        this.normal = normal;
        this.bonus = bonus;
    }

    public static Score generateEmptyScore() {
        return new Score(0, 0);
    }

    public Ranking generateRank() {
        return Ranking.calculateScore(this);
    }

    public Score plusNormal(final Integer count) {
        return new Score(this.normal + count, this.bonus);
    }

    public Score plusBonus() {
        return new Score(this.normal, this.bonus + BONUS_COUNT);
    }

    public String resultMatchCount() {
        var allCount = normal + bonus;

        if (allCount < MIN_COUNT) {
            return MESSAGE_NOTHING;
        }

        if (normal.equals(CHECK_NORMAL_COUNT) && bonus.equals(BONUS_COUNT)) {
            return String.format(MESSAGE_N_AMOUNT_CORRECT + MESSAGE_BONUS_CORRECT, normal);
        }

        return String.format(MESSAGE_N_AMOUNT_CORRECT, allCount);
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


}
