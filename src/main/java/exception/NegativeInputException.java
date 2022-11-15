package exception;

import java.lang.reflect.Member;

public class NegativeInputException extends IllegalArgumentException{
    public NegativeInputException() {
        super("[ERROR] Negative input error");
    }
}
