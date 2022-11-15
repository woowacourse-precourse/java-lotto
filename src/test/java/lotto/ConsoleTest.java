package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsoleTest extends NsTest{
    private static final String ERROR_MESSAGE = "[ERROR]";


    @DisplayName("구입금액에 문자가 들어갈 수 없습니다.")
    @Test
    void 구입금액_예외처리1() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구입금액에 천단위가 아닌 숫자는 들어갈 수 없습니다.")
    @Test
    void 구입금액_예외처리2() {
        assertSimpleTest(() -> {
            runException("100");
            assertThat(output()).contains(ERROR_MESSAGE);
        });

        assertSimpleTest(() -> {
            runException("0000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨번호는 구분자와 숫자들로 이루어 집니다.")
    @Test
    void 당첨번호_예외처리1() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,6,");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("1000","123456");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨번호는 로또의 범위내에 존재 해야합니다.")
    @Test
    void 당첨번호_예외처리2() {
        assertSimpleTest(() -> {
            runException("1000","0,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("1000","100,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨번호는 중복될 수 없습니다.")
    @Test
    void 당첨번호_예외처리3() {
        assertSimpleTest(() -> {
            runException("1000","11,11,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("보너스번호는 당첨번호와 중복 될 수 없습니다.")
    @Test
    void 보너스번호_예외처리1() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,6","6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스번호는 로또 번호 범위 내에 존재해야합니다.")
    @Test
    void 보너스번호_예외처리2() {
        assertSimpleTest(() -> {
            runException("1000","1,2,3,4,5,6","46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
