package lotto.exception;

import java.util.NoSuchElementException;

public class IllegalLottoNumberException extends IllegalArgumentException {

    public IllegalLottoNumberException() {
    }

    public IllegalLottoNumberException(String message) {
        throw new NoSuchElementException(message);
    }

}
