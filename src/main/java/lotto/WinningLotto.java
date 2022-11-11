package lotto;

import java.util.List;

public class WinningLotto extends Lotto {

    int bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public void inputBonusNumber(int bonusNumber){
        validateNumber(bonusNumber);
        this.bonusNumber=bonusNumber;
    }
}
