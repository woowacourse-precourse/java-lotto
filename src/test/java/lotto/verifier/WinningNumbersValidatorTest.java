package lotto.verifier;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersValidatorTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("당첨번호는 \"숫자,숫자,숫자...\" 형식이어야한다")
    @Test
    void 당첨번호_형식() {
        assertSimpleTest(() -> {
            runException("1000", ",12,as,23,1,22,2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨번호는 총 6개의 숫자로 이루어져야한다")
    @Test
    void 당첨번호_숫자_6개() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨번호끼리 중복되지 않아야한다")
    @Test
    void 당첨번호_중복() {
        assertSimpleTest(() -> {
            runException("1000", "1,1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨번호의 숫자는 1부터 45 사이의 숫자여야한다")
    @Test
    void 당첨번호_숫자범위() {
        assertSimpleTest(() -> {
            runException("1000", "0,1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}