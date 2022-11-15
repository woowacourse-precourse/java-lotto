package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void examineDivideBy1000() {
        assertSimpleTest(() -> {
            runException("12345");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("정수 외에 구입 금액은 예외가 발생한다.")
    @Test
    void isDigitPrice() {
        assertSimpleTest(() -> {
            runException("10k00e");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("9999.9");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}