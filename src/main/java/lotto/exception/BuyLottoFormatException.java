package lotto.exception;

public class BuyLottoFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 구매 금액에 숫자가 아닌 다른 입력값이 들어왔습니다.";

    public BuyLottoFormatException() {
        super(ERROR_MESSAGE);
    }
}
