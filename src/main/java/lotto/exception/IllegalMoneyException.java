package lotto.exception;

import java.util.NoSuchElementException;

public class IllegalMoneyException extends IllegalArgumentException {

    public IllegalMoneyException(String message) {
        throw new NoSuchElementException(message);
    }
}
