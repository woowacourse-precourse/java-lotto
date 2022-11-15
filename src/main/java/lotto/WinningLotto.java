package lotto;

import java.util.List;

public class WinningLotto {
    private List<Integer> winningNumbers;

    WinningLotto(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
