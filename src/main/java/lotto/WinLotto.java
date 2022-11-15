package lotto;

import lotto.exception.MyIllegalArgumentException;

import java.util.LinkedList;
import java.util.List;

import static lotto.exception.ErrorCode.BONUS_NUMBER_ERROR;

public class WinLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinLotto(List<Integer> winNumbers, int bonusNumber) {
        validate(winNumbers, bonusNumber);
        this.lotto = new Lotto(winNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new MyIllegalArgumentException(BONUS_NUMBER_ERROR);
        }
    }

    public List<Integer> compare(Lotto userLotto) {
        List<Integer> common = new LinkedList<>();
        for (int number : userLotto.getNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                common.add(number);
            }
        }
        return common;
    }
}
