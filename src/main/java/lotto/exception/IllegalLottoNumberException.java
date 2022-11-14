package lotto.exception;

import java.util.NoSuchElementException;

public class IllegalLottoNumberException extends RuntimeException {

    public IllegalLottoNumberException() {
        throw new IllegalArgumentException();
    }

    public IllegalLottoNumberException(String s) {
        throw new IllegalArgumentException();
    }

}
