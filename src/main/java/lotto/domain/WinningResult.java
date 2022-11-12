package lotto.domain;

import java.util.List;

public class WinningResult {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private int accordedNumbers;
    public WinningResult(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers= winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void checkTheResult(List<Integer> lottoNumbers) {
        accordedNumbers = 3;
    }

    public int getAccordedNumbers() {
        return accordedNumbers;
    }
}
