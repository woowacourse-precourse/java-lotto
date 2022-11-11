import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandlingTest {

    @DisplayName("1000으로 나누어떨어지지 않으면 IllegalArgumentException을 발생시킴")
    @Test
    void notDivideException() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        assertThatThrownBy(() -> exceptionHandling.notDivideException(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}