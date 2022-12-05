package lotto.domain;

import java.util.List;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber, Lotto winningLotto) {
        validate(bonusNumber,winningLotto);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber, Lotto winningLotto) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호의 숫자 범위는 1~45까지입니다.");
        }
        if(winningLotto.contains(bonusNumber)){
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public boolean isIn(List<Integer> myLotto) {
        return myLotto.contains(bonusNumber);
    }
}
