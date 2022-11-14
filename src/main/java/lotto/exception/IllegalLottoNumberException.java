package lotto.exception;

import java.util.NoSuchElementException;

public class IllegalLottoNumberException extends IllegalArgumentException {

    public IllegalLottoNumberException() {
    }

    public IllegalLottoNumberException(String s) {
        throw new NoSuchElementException(s);
    }

}
