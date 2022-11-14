package lotto.domain;

import java.util.List;

public class Winning {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public Winning(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Winning(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
