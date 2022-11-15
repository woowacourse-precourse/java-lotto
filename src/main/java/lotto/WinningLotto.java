package lotto;

import java.util.HashSet;
import java.util.List;

public class WinningLotto extends Lotto {


    private int bonusNumber;

    public int getBonusNumber() {
        return bonusNumber;
    }

    public WinningLotto(List<Integer> numbers,int bonusNumber) throws IllegalArgumentException {
        super(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    private void validateBonusNumber(int bonusNumber) throws IllegalArgumentException{
        validateNumberRange(bonusNumber);
        List<Integer> numbers = this.getNumbers();
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호는 모두 달라야 합니다.");
        }
    }

}
