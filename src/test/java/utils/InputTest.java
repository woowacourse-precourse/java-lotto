package utils;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import system.process.exception.IllegalArgument;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {
    @DisplayName("잘못된 형태의 입력이라면 예외 발생.")
    @Test
    void inputWrongText() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.NOT_DIGIT_OR_COMMA_TEXT.getMessage())
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12m"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(IllegalArgument.NOT_DIGIT_OR_COMMA_TEXT.getMessage())
        );
    }

    @Override
    protected void runMain() {
        Input.input();
    }
}
