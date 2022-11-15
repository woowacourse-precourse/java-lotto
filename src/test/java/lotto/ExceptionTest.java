package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 로또_구분자_입력_테스트() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,5_8", "9");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 로또_자릿수_테스트() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,7", "5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 로또_문자_입력_테스트() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,5,aaa", "8");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 로또_중복_테스트() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,7,7", "8");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 보너스번호_중복_테스트() {
        assertSimpleTest(() -> {
            runException("3000", "1,2,3,4,6,45", "45");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
