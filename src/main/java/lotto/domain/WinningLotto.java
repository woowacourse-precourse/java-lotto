package lotto.domain;

import java.util.List;

public class WinningLotto {

    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        checkContainsBonusNumber();
    }

    public void checkContainsBonusNumber() {
        List<Integer> winningNumbers= winningLotto.getNumbers();

        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException();
        }
    }
}
