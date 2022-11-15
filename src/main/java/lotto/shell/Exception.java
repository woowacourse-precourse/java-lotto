package lotto.shell;


import static lotto.shell.AlertEnumeration.AMOUNT_EXCEPTION;
import static lotto.shell.AlertEnumeration.INVALID_EXCEPTION;
import static lotto.shell.AlertEnumeration.SIZE_EXCEPTION;

// 예외 처리를 책임지는 기능
public class Exception {

    private String alertAmount;
    private String alertInvalid;
    private String alertSize;

    public Exception() {
        this.alertAmount = AMOUNT_EXCEPTION.getAmountEnumeration();
        this.alertInvalid = INVALID_EXCEPTION.getInvalidEnumeration();
        this.alertSize = SIZE_EXCEPTION.getSizeEnumeration();
    }

    // 1,000원으로 나누어 떨어지지 않는 경우 예외 처리
    public void amountException() {

        throw new IllegalArgumentException(alertAmount);

    }

    // 잘못된 값 입력 예외처리
    public void invalidException() {

        throw new IllegalArgumentException(alertInvalid);

    }

    // 잘못된 값 입력 예외처리
    public void sizeException() {

        throw new IllegalArgumentException(alertSize);
    }

}
