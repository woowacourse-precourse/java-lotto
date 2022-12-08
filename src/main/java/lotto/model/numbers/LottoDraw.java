package lotto.model.numbers;

import java.util.Collections;
import java.util.List;
import lotto.util.ExceptionMessage;

public class LottoDraw {

    private final Lotto lotto;
    private final Bonus bonus;

    private LottoDraw(Lotto lotto, Bonus bonus) {
        validateDuplicates(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static LottoDraw by(Lotto lotto, Bonus bonus) {
        return new LottoDraw(lotto, bonus);
    }

    private void validateDuplicates(Lotto lotto, Bonus bonus) {
        if (lotto.contains(bonus.getBonusNumber())) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        return lotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonus.getBonusNumber();
    }
}
