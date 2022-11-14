package lotto;

import lotto.data.Error;
import lotto.domain.ExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionHandlerTest {

    @DisplayName("입력값이 숫자가 아닐 경우, 예외 발생")
    @Test
    public void checkNumeric() {
        String input = "10,30f";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> ExceptionHandler.checkNumeric(input));

        assertEquals(exception.getMessage(), Error.NOT_NUMERIC.getMessage());
    }

    @DisplayName("입력받은 금액이 1000원으로 나누어 떨어지지 않은 경우, 예외 발생")
    @Test
    public void checkNotDivisibleByThousand() {
        int price = 1023;

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> ExceptionHandler.checkNotDivisibleByThousand(price));

        assertEquals(exception.getMessage(), Error.NOT_DIVISIBLE_BY_THOUSAND.getMessage());
    }

    @DisplayName("숫자 범위가 1부터 45가 아닌 경우, 예외 발생")
    @Test
    public void checkNumberOutOfRange() {
        int number = 46;

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> ExceptionHandler.checkOutOfRange(number));

        assertEquals(exception.getMessage(), Error.OUT_OF_RANGE.getMessage());
    }

    @DisplayName("숫자 범위가 1부터 45가 아닌 경우, 예외 발생")
    @Test
    public void checkNumbersOutOfRange() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 67);

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> ExceptionHandler.checkOutOfRange(numbers));

        assertEquals(exception.getMessage(), Error.OUT_OF_RANGE.getMessage());
    }

    @DisplayName("숫자 개수가 6개를 초과하는 경우, 예외 발생")
    @Test
    public void checkOverSize() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> ExceptionHandler.checkInvalidSize(numbers));

        assertEquals(exception.getMessage(), Error.INVALID_SIZE.getMessage());
    }

    @DisplayName("중복된 숫자가 포함되는 경우, 예외 발생")
    @Test
    public void checkDuplicateNumber() {
        List<Integer> numbers = List.of(1, 1, 2, 3, 4, 5);

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> ExceptionHandler.checkDuplicateNumber(numbers));

        assertEquals(exception.getMessage(), Error.DUPLICATE_NUMBER.getMessage());
    }
}