package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ErrorTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("로또 당첨 번호에 따옴표가 6개 이상 포함되어 있으면 에러를 표시한다.")
    @Test
    void 당첨번호_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 당첨 번호에 문자가 포함되어 있으면 에러를 표시한다.")
    @Test
    void 당첨번호_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("1000", "1,c,b,a,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 당첨 번호가 빈 값이면 에러를 표시한다.")
    @Test
    void 당첨번호_예외_테스트3() {
        assertSimpleTest(() -> {
            runException("1000", " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 당첨 번호에 빈 값이 포함되어 있으면 에러를 표시한다.")
    @Test
    void 당첨번호_예외_테스트4() {
        assertSimpleTest(() -> {
            runException("1000", "1,,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 로또 당첨 번호와 중복되면 에러를 표시한다.")
    @Test
    void 보너스번호_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "3");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 범위를 벗어나면 에러를 표시한다.")
    @Test
    void 보너스번호_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 문자를 포함하면 에러를 표시한다.")
    @Test
    void 보너스번호_예외_테스트3() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 빈 값이면 에러를 표시한다.")
    @Test
    void 보너스번호_예외_테스트4() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", " ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
