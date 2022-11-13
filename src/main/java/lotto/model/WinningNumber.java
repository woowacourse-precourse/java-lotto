package lotto.model;

import static lotto.model.InputErrorMessage.DUPLICATE_BONUS_NUMBER;

import java.util.List;

public class WinningNumber extends Lotto{
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        validateDuplicateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateDuplicateBonusNumber(int bonusNumber) {
        if(hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getErrorMessage());
        }
    }

    @Override
    public int countSameNumber(Lotto userLotto) {
        int numberCount = super.countSameNumber(userLotto);
        boolean hasBonusNumber = userLotto.hasNumber(bonusNumber);
        if(hasBonusNumber) {
            numberCount++;
        }
        return numberCount;
    }
}
