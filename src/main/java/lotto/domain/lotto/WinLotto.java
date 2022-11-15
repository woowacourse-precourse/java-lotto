package lotto.domain.lotto;
import lotto.error.ErrorMsg;

import java.util.List;

public class WinLotto extends Lotto{
    private int bonusNumber;

    public WinLotto(List<Integer> numbers) {
        super(numbers);
    }

    public WinLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
    public void setBonusNumber(int bonusNumber){
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validate(int bonus){
        for (int num : this.getNumbers())
            if (bonus == num)
                throw new IllegalArgumentException(ErrorMsg.DUPLICATE_BONUS_NUMBER.toString());
    }
}
