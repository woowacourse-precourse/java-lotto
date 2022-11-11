package lotto;

import java.util.List;

public class WinningLotto extends Lotto {

    int bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public void inputBonusNumber(int bonusNumber){
        validateNumber(bonusNumber);
        checkWinningAndBonusIsOverlap(bonusNumber);
        this.bonusNumber=bonusNumber;
    }

    private void checkWinningAndBonusIsOverlap(int bonusNumber){
        if(getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException("로또 번호는 중복되면 안됩니다.");
        }
    }

}
