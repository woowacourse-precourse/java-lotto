import lotto.ExceptionHandling;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandlingTest {

    @DisplayName("1000으로 나누어떨어지지 않으면 IllegalArgumentException을 발생시킴")
    @Test
    void notDivideException() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        assertThatThrownBy(() -> exceptionHandling.notDivideException(3000000000L))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("숫자인지 검사")
    @Test
    void isNumeric(){
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        assertThatThrownBy(() -> exceptionHandling.isNumeric("123$"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}