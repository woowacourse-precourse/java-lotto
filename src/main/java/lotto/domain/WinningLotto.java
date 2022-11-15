package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import lotto.view.ExceptionMessage;

public class WinningLotto extends Lotto {

    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
        checkContainsBonusNumber();
    }

    public void checkContainsBonusNumber() {
        if (getNumbers().contains(bonusNumber)) {
            ExceptionMessage.existBonusNumberError();
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoGrade getLottoGrade(Lotto lotto) {
        int correct = compareToWinningLotto(lotto);
        boolean bonus = compareToBonusNumber(lotto);

        return LottoGrade.getGrade(correct, bonus);
    }

    public int compareToWinningLotto(Lotto lotto) {
        int result = (int) lotto.getNumbers().stream()
                .filter(number -> getNumbers().stream()
                        .anyMatch(Predicate.isEqual(number)))
                .count();
        return result;
    }

    public boolean compareToBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(getBonusNumber());
    }
}
