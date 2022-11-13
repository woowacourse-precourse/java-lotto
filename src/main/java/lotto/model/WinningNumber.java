package lotto.model;

import java.util.List;

public class WinningNumber extends Lotto{
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        this.bonusNumber = bonusNumber;
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
