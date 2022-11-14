package lotto.model;

import lotto.type.PrizeType;
import lotto.util.Lang;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Raffle {
    private final Lotto lotto;
    private Bonus bonus;

    public Raffle(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Raffle(Lotto lotto) {
        this.lotto = lotto;
    }

    public void setBonus(Bonus bonus) {
        this.validateBonusNotNull();
        this.bonus = bonus;
    }

    private void validateBonusNotNull() {
        if (bonus != null) {
            throw new RuntimeException(Lang.VARIABLE_NOT_DECLARE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Raffle raffle = (Raffle) o;

        return (Objects.equals(lotto, raffle.lotto)
                && Objects.equals(bonus, raffle.bonus));
    }

    @Override
    public int hashCode() {
        int result = 0;
        result += this.getHashCode(this.lotto);
        result *= 31;
        result += this.getHashCode(this.bonus);

        return result;
    }

    private int getHashCode(Object object) {
        int number = 0;

        if (object != null) {
            number = object.hashCode();
        }

        return number;
    }

    public PrizeType getPrizeTypeWith(Lotto lotto) {
        return Arrays.stream(PrizeType.values())
                .filter(prizeType -> this.comparePrizeTypeAndLotto(prizeType, lotto))
                .findFirst()
                .orElse(PrizeType.NOTHING);
    }

    private boolean comparePrizeTypeAndLotto(PrizeType prizeType, Lotto other) {
        int matchLotto = this.countMatchLotto(other);
        int matchBonus = this.countMatchBonus(prizeType, other);
        Score lottoScore = new Score(matchLotto, matchBonus);

        return prizeType
                .getCondition()
                .equals(lottoScore);
    }

    private int countMatchLotto(Lotto other) {
        return this.lotto.retainAll(other).size();
    }

    private int countMatchBonus(PrizeType prizeType, Lotto other) {
        Score condition = prizeType.getCondition();

        if (!condition.hasBonusNumber()) {
            return 0;
        }

        return Boolean.compare(other.contains(this.bonus), false);
    }
}
