package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        lotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }
}
