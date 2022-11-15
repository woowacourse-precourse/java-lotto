package lotto.domain.lotto;

import java.util.List;

public class WinningLotto extends Lotto {

    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int match(Lotto lotto) {
        int count = 0;
        for (int winningNumber : this.getNumbers()) {
            if (lotto.getNumbers().contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    public boolean checkBonus(Lotto lotto) {
        return lotto.getNumbers().contains(this.bonusNumber);
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자에 보너스 숫자와 같은 숫자가 존재합니다.");
        }
    }
}
