package exception;

import static validation.Validator.ERROR_MESSAGE;

import lotto.Lotto;

public class InvalidBonusNumberSizeException extends IllegalArgumentException {
    public InvalidBonusNumberSizeException() {
        super(ERROR_MESSAGE + "보너스 번호는 " + Lotto.BONUS_SIZE + "개 입니다.");
    }
}
