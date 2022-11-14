package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> lotto, int bonusNumber) {
        super(lotto);
        this.bonusNumber = bonusNumber;
    }

    public int lottoContainsCount(List<Integer> lotto) {
        int count = 0;
        for (Integer number : lotto) {
            if (this.lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
