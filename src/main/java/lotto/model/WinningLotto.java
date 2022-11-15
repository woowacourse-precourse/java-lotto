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

    public Rank calculateRank(Lotto userLotto) {
        int sameNumberCount = super.countSameNumber(userLotto);
        boolean isBonus = hasBonusNumber(userLotto);
        return Rank.getRank(sameNumberCount, isBonus);
    }

    public boolean hasBonusNumber(Lotto userLotto) {
        return userLotto.hasNumber(bonusNumber);
    }
}
