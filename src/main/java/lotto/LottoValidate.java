package lotto;

import java.util.List;

public class LottoValidate {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoValidate(Lotto winningLotto ,int bonusNumber){
        bonusValidate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public void bonusValidate(Lotto winningLotto, int bonusNumber){
        if (winningLotto.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 6개의 로또 번호와 중복이 불가합니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }
}
