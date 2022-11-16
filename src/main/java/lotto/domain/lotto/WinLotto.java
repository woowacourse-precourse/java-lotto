package lotto.domain.lotto;

import lotto.exception.lotto.BonusDuplicatedException;
import lotto.exception.lotto.BonusRangeException;

public class WinLotto {

    private static final int MAX = 45;
    private static final int MIN = 1;

    private final Lotto lotto;
    private final int bonus;

    public WinLotto(Lotto winLotto, int bonus) {
        validate(winLotto, bonus);
        validateBonus(bonus);
        this.bonus = bonus;
        this.lotto = winLotto;
    }

    public static WinLotto of(Lotto winLotto, int bonus) {
        return new WinLotto(winLotto, bonus);
    }

    private void validate(Lotto winLotto, int bonus) {
        if (winLotto.contains(bonus)) {
            throw new BonusDuplicatedException(winLotto.get(),bonus);
        }
    }

    private void validateBonus(int bonus) {
        if (bonus > MAX || bonus < MIN) {
            throw new BonusRangeException(bonus);
        }
    }

    public Lotto get() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }

    public boolean contains(Integer number) {
        return lotto.contains(number);
    }
}
