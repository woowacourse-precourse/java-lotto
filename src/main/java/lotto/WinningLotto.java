package lotto;

import java.util.List;

public class WinningLotto extends Lotto{
    int bonusNumber;

    public WinningLotto(List<Integer> numbers,int bonusNumber) throws IllegalArgumentException {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }
}
