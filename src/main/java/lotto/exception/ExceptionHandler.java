package lotto.exception;

import lotto.constant.ErrorMessage;
import lotto.userinterface.Output;

public class ExceptionHandler {
    public ExceptionHandler() {
    }

    public static void isMultipleOf(long target, int multiple){
        if (target % multiple != 0) {
            Output.printMessage(ErrorMessage.NOT_MULTIPLE_ERROR.getMessage(multiple));
            throw new IllegalArgumentException();
        }
    }
}
