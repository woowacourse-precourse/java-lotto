package lotto;

import java.util.List;

public class DrawingMachine {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public DrawingMachine(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
