package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class WinningLotto {

    private final int bonusNumber;

    private final List<Integer> winningNumbers;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
     public List<Integer> getWinningNumbers(){
        return this.winningNumbers;
     }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
