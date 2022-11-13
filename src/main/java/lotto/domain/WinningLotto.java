package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningLotto(Lotto winningNumbers,int bonusNumber){
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}