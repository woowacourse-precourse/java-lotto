package lotto;

import org.assertj.core.api.ThrowableAssertAlternative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ExceptionTest {

    private Exception exception;

    @BeforeEach
    void setUp() {
        exception = new Exception();
    }

    @DisplayName("예외 발생 테스트")
    @Test
    void createExceptionTest_isNotIntegerException() {
        Throwable testException = assertThrows(IllegalArgumentException.class, () -> exception.isNotIntegerException());
        assertEquals(testException.getMessage(), "[ERROR]: not integer exception");
    }

    @DisplayName("예외 발생 테스트")
    @Test
    void createExceptionTest_isMoneyUnitException() {
        Throwable testException = assertThrows(IllegalArgumentException.class, () -> exception.isMoneyUnitException());
        assertEquals(testException.getMessage(), "[ERROR]: payment amount exception");
    }
}
