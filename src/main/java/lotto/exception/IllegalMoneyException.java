package lotto.exception;

import java.util.NoSuchElementException;

public class IllegalMoneyException extends RuntimeException{

    public IllegalMoneyException() {
    }

    public IllegalMoneyException(String s) {
        throw new IllegalArgumentException();
    }
}
