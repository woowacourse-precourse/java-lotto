package lotto.domain.exception;

import java.util.NoSuchElementException;

public class IllegalArgumentException extends NoSuchElementException {
    public IllegalArgumentException(String errorMessage) {
        System.out.println(errorMessage);
    }
}
