package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    private int bonusNumber;

    public WinningLotto(List<Integer> numbers,int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
        checkContainsBonusNumber();
    }

    public void checkContainsBonusNumber() {
        if(getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 입력한 보너스 번호가 이미 당첨 번호에 존재합니다.");
        }
    }
}
