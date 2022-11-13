package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto winninglotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        winninglotto = lotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 0에서 45 사이의 숫자를 입력해야 합니다.");
        }
        if (winninglotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호에 존재하는 숫자를 입력하면 안됩니다.");
        }
    }

    public int countMatchNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int countMatchNumbers = 0;

        for (int number : numbers) {
            if (winninglotto.getNumbers().contains(number)) {
                countMatchNumbers++;
            }
        }
        return countMatchNumbers;
    }

    public boolean checkBonusNumber(Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
