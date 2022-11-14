package lotto.domain;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.constant.ConstValue.DIGIT_REGEX;
import static lotto.constant.Message.*;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Rank compareLottoNumber(Lotto lotto) {
        int countOfMatch = getCountOfMatch(lotto);
        boolean isMatchedBonus = isMatchedBonus(lotto);

        return Rank.makeRank(countOfMatch, isMatchedBonus);
    }

    private boolean isMatchedBonus(Lotto lotto) {
        return lotto.getNumbers().contains(this.bonusNumber);
    }

    private int getCountOfMatch(Lotto lotto) {
        return (int) this.getNumbers()
                .stream()
                .filter(
                        number ->
                                lotto.getNumbers().contains(number)
                )
                .count();
    }
}
