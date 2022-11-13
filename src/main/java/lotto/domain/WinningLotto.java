package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto winninglotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        winninglotto = lotto;
        this.bonusNumber = bonusNumber;
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
