package lotto.model;

import static lotto.model.InputErrorMessage.DUPLICATE_BONUS_NUMBER;

import java.util.List;

public class WinningLotto extends Lotto{
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        validateDuplicateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateDuplicateBonusNumber(int bonusNumber) {
        if (hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getErrorMessage());
        }
    }

    @Override
    public int countSameNumber(Lotto userLotto) {
        int numberCount = super.countSameNumber(userLotto);
        if(numberCount < 5) {
            return numberCount;
        }
        boolean hasBonusNumber = userLotto.hasNumber(bonusNumber);
        if(hasBonusNumber) {
            numberCount++;
        }
        return numberCount;
    }
}
