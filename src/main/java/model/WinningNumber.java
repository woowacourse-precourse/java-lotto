package model;

import static model.LottoStatus.END;
import static model.LottoStatus.START;

public class WinningNumber {
    private final Lotto luckyNumber;
    private final int bonusNumber;

    public WinningNumber(Lotto luckyNumber, int bonusNumber) {
        this.luckyNumber = luckyNumber;
        validateRange(bonusNumber);
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
}
