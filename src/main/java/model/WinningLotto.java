package model;

import java.util.List;

import static constant.Config.ERROR;


public class WinningLotto {
    private static final String DUPLICATE_ERROR = String.format("%s 보너스 번호는 로또 번호와 중복되지 않아야 합니다.", ERROR);
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        validateDuplicate(winningLotto.getNumbers(), bonusNumber.getBonusNumber());

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }
}
