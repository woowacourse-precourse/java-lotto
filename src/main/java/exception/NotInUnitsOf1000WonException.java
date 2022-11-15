package exception;

import static validation.Validator.ERROR_MESSAGE;

import lotto.Lotto;

public class NotInUnitsOf1000WonException extends IllegalArgumentException {
    public NotInUnitsOf1000WonException() {
        super(ERROR_MESSAGE + Lotto.PRICE + "원 단위의 금액을 입력해 주세요.");
    }
}
