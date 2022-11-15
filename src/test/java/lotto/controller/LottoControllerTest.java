package lotto.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구입 금액이 천 원 미만의 값인 경우 예외처리한다")
    @Test
    void 구입_금액_예외_테스트() {
        assertSimpleTest(() -> {
            runException("-1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구입 금액이 천 원 단위가 아닌 경우 예외처리한다")
    @Test
    void 구입_금액_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("1111");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호에 숫자가 아닌 문자가 있을 경우 예외처리한다")
    @Test
    void 당첨_번호_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3000", "33,1,@#%A,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호의 개수가 6개가 아닐 경우 예외처리한다")
    @Test
    void 당첨_번호_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("3000", "12,2,4,5,6", "9");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호에 숫자가 아닌 문자가 있을 경우 예외처리한다")
    @Test
    void 보너스_번호_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3000", "12,2,4,5,6,7", "89!@#8");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("보너스 번호가 로또 번호 범위에 속하지 않을 경우 예외처리한다")
    @Test
    void 보너스_번호_예외_테스트2() {
        assertSimpleTest(() -> {
            runException("3000", "12,2,4,5,6,7", "99");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}