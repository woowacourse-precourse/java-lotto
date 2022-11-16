package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerTest extends NsTest {
    @DisplayName("당첨 번호에 숫자가 아닌 다른 값이 있으면 예외 발생 1).")
    @Test
    void checkAnswerException1() {

        assertSimpleTest(() -> {
            runException("1000", "1,2,3,5,6,a");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @DisplayName("당첨 번호에 ','가 아닌 다른 값이 있으면 예외 발생 1).")
    @Test
    void checkAnswerException2() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,5,6,a");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @DisplayName("당첨번호에 숫자가 범위 내 숫자가 6개가 들어있는지 확인.")
    @Test
    void checkAnswerException3() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,5,6,7,8");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @DisplayName("당첨 번호에 ',,' 가 있는 경우 예외 발생).")
    @Test
    void checkAnswerException4() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,5,,8");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @DisplayName("당첨 번호가 ',' 로 끝나는 경우.")
    @Test
    void checkAnswerException5() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,5,6,");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @DisplayName("당첨 번호에 중복되는 숫자가 있는 경우 1.")
    @Test
    void checkAnswerException6() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,5,6,6");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @DisplayName("당첨 번호에 중복되는 숫자가 있는 경우 2.")
    @Test
    void checkAnswerException7() {
        assertSimpleTest(() -> {
            runException("1000", "6,6,6,6,6,6");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @DisplayName("당첨 번호가 null로 들어오는 경우")
    @Test
    void checkAnswerException8() {
        assertSimpleTest(() -> {
            runException("1000", null);
            assertThat(output()).contains("[ERROR]");
        });
    }

    @DisplayName("당첨 번호에 -0이 있는 경우 2.")
    @Test
    void checkAnswerException9() {
        assertSimpleTest(() -> {
            runException("1000", "-0,6,7,8,9,10");
            assertThat(output()).contains("[ERROR]");
        });
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}