package lotto.entity;

import static lotto.LottoApplication.RANGE_END;
import static lotto.LottoApplication.RANGE_START;

import java.util.Arrays;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        winningLotto = lotto;
        validate(bonus);
        this.bonus = bonus;
    }

    private void validate(int bonus) {
        validateRange(bonus);
        validateDuplication(bonus);
    }

    private void validateRange(int bonus) {
        if (outOfRange(bonus)) {
            throw new IllegalArgumentException(
                    String.format("보너스 번호는 %d부터 %d사이 숫자여야 합니다. 입력 : %d", RANGE_START, RANGE_END,
                            bonus));
        }
    }

    private boolean outOfRange(int bonus) {
        return RANGE_START > bonus || RANGE_END < bonus;
    }

    private void validateDuplication(int bonus) {
        if (winningLotto.contains(bonus)) {
            throw new IllegalArgumentException(
                    String.format("보너스 번호는 로또 번호와 중복된 숫자를 가지면 안됩니다. 입력 : %d", bonus));
        }
    }

    public Rank compare(Lotto lotto) {
        int count = getMatchCount(lotto);
        boolean bonus = lotto.contains(this.bonus);
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.win(count, bonus))
                .findFirst()
                .orElse(Rank.NONE);
    }

    private int getMatchCount(Lotto lotto) {
        return (int) lotto.cloneNumbers()
                .stream()
                .filter(winningLotto::contains)
                .count();
    }

}
