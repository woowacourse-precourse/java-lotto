package lotto.domain;

import lotto.view.InputView;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public static WinningLotto create() {
        InputView input = new InputView();
        return new WinningLotto(input.readWinningLotto());
    }

    private WinningLotto(List<Integer> numbers) {
        super(numbers);
        this.bonusNumber = new InputView().readBonusNumber();
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        super.validateLottoNumberRange(bonusNumber);
        if (super.contain(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public boolean isBonusNumberIn(Lotto lotto) {
        return lotto.contain(bonusNumber);
    }
}
