package lotto.ExceptionTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import lotto.Exception.Exception;
public class ExceptionTest {

    Exception exception = new Exception();

    @Test
    public void throwInvalidInputExceptionTest() {
        try {
            exception.throwInvalidInputException();
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("[ERROR] 잘못된 입력 형식입니다.", e.getMessage());
        }
    }

    @Test
    public void throwInvalidNumberRangeException() {
        try {
            exception.throwInvalidNumberRangeException();
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("[ERROR] 잘못된 숫자 범위입니다.", e.getMessage());
        }
    }

    @Test
    public void throwInvalidSizeException() {
        try {
            exception.throwInvalidSizeException();
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("[ERROR] 입력 숫자의 개수는 6개여야 합니다.", e.getMessage());
        }
    }
}
