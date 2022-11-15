package lotto.Exception;

import lotto.Printer.Message;

public class Exception {

    public void throwInvalidInputException() throws IllegalArgumentException {
        throw new IllegalArgumentException(Message.INVALID_INPUT_ERROR.getPrintingMessage());
    }

    public void throwInvalidNumberRangeException() throws IllegalArgumentException {
        throw new IllegalArgumentException(Message.INVALID_NUMBER_RANGE_ERROR.getPrintingMessage());
    }

    public void throwInvalidSizeException() throws IllegalArgumentException {
        throw new IllegalArgumentException(Message.INVALID_SIZE_ERROR.getPrintingMessage());
    }
}
