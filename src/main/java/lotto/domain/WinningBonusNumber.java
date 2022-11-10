package lotto.domain;

import java.util.List;

public class WinningBonusNumber {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningBonusNumber(List<Integer> winningNumbers, int bonusNumber) {

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }


}
