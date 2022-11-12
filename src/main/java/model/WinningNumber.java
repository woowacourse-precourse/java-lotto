package model;

import java.util.List;

import static model.LottoStatus.END;
import static model.LottoStatus.START;

public class WinningNumber {
    private final Lotto luckyNumber;
    private final int bonusNumber;

    public WinningNumber(Lotto luckyNumber, int bonusNumber) {
        this.luckyNumber = luckyNumber;
        validateRange(bonusNumber);
        validateDuplication(luckyNumber, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.toString());
        }
    }

    private boolean isOutOfRange(int bonusNumber) {
        return bonusNumber < START.getValue() || END.getValue() < bonusNumber;
    }

    private void validateDuplication(Lotto luckyNumber, int bonusNumber) {
        if (isDuplicate(luckyNumber, bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION.toString());
        }
    }

    private boolean isDuplicate(Lotto luckyNumber, int bonusNumber) {
        return getLuckyNumber(luckyNumber).contains(bonusNumber);
    }

    private List<Integer> getLuckyNumber(Lotto luckyNumber) {
        return luckyNumber.getNumbers();
    }
}
