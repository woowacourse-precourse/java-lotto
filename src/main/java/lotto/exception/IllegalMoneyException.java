package lotto.exception;

import java.util.NoSuchElementException;

public class IllegalMoneyException extends IllegalArgumentException{

    public IllegalMoneyException() {
    }

    public IllegalMoneyException(String s) {
        throw new NoSuchElementException();
    }
}
