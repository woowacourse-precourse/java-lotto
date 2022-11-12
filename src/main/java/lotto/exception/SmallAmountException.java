package lotto.exception;

public class SmallAmountException extends IllegalArgumentException {

    private static final String MESSAGE = "[ERROR] 구입 최소 금액은 1000원입니다.";

    public SmallAmountException(){
        super(MESSAGE);
    }
}
