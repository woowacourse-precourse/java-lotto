package lotto.ui;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputWinningLottoTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    @Test
    void 당첨번호_중복() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("2,2,3,4,5,6"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_MESSAGE + " 로또 번호는 서로 다른 숫자여야 합니다.");
        });
    }
    @Test
    void 당첨번호_1범위초과() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,2,-1,4,5,6"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
    }
    @Test
    void 당첨번호_45범위초과() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,2,46,4,5,6"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
    }
    @Test
    void 당첨번호_정수아닌소수() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,2,40.0,4,5,6"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_MESSAGE + " 당첨번호는 쉼표를 기준으로 구분되고 정수를 입력해야합니다.");
        });
    }
    @Test
    void 당첨번호_정수아닌문자() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(" 1,2,3,4,5,6"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_MESSAGE + " 당첨번호는 쉼표를 기준으로 구분되고 정수를 입력해야합니다.");
        });
    }

    @Override
    public void runMain() {
        Input.scanWinningLotto();
    }
}
