package model;

import java.util.List;

public class WinningLotto {
    private static final String DUPLICATE_ERROR = "보너스 번호는 로또 번호와 중복되지 않아야 합니다.";
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        validateDuplicate(winningLotto.getNumbers(), bonusNumber.getBonusNumber());

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningLotto() {
        return winningLotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }

    private void validateDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }
}
