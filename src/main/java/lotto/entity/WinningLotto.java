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
        if (outOfRange(bonus)) {
            throw new IllegalArgumentException(
                "보너스 번호는 " + RANGE_START + "부터 " + RANGE_END
                    + " 사이의 숫자여야 합니다. 입력 : " + bonus);
        }
        if (winningLotto.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복된 숫자를 가지면 안됩니다. 입력 : " + bonus);
        }
    }

    private boolean outOfRange(int bonus) {
        return RANGE_START > bonus || RANGE_END < bonus;
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
        return (int) winningLotto.cloneNumbers()
            .stream()
            .filter(lotto::contains)
            .count();
    }

}
