package lotto.exception;

public class BuyLottoException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 구매 금액은 1,000원 단위로 입력해야 합니다.";

    public BuyLottoException() {
        super(ERROR_MESSAGE);
    }
}
