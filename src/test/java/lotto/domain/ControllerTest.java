package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ControllerTest {
    private static Controller controller;

    @DisplayName("테스트를 위해 Controller 클래스를 Mocking 처리한다.")
    @BeforeAll
    public static void beforeALl() {
        controller = mock(Controller.class);
    }

    @DisplayName("숫자 형식의 문자열이 아닐 때 예외가 발생한다.")
    @Test
    void testNotNumericString() throws NoSuchMethodException {
        Method checkNumericStringMethod = Controller.class.getDeclaredMethod("checkNumericString", String.class);
        checkNumericStringMethod.setAccessible(true);

        String noNumericString = "1000j";

        assertThatThrownBy(() -> checkNumericStringMethod.invoke(controller, noNumericString)).getCause()
                .isInstanceOf(IllegalArgumentException.class);
    }
}
