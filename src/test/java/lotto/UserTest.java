package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("1000으로 나누엊지 않는 숫자면 예외가 발생한다.")
    @Test
    void inputByNotDividedBy1000() {
        assertSimpleTest(() -> {
            runException("10001");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
