package lotto.exception;

public class DivideMoneyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "";

    public DivideMoneyException() {
        super(ERROR_MESSAGE);
    }
}
