package lotto.exception;

import java.util.NoSuchElementException;

public class IllegalArgumentException extends NoSuchElementException {

    public IllegalArgumentException(String message){
        super(message);
    }
}
