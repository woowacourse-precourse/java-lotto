package lotto.model;

import java.util.List;
import java.util.ArrayList;

public class WinningNumber extends Lotto {
    private int bonusNumber;

    public WinningNumber(List<Integer> numbers) {
        super(numbers);
    }

    public void setBonusNumber(int number) {
        this.bonusNumber = number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
