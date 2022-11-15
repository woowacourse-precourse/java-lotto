package lotto.buyLotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetMoneyTest extends NsTest {

    @DisplayName("입력 받은 금액이 1000으로 나누어 떨어 지지 않을 경우 에러를 발생")
    @Test
    void createLottoByWrongInput() {
        assertSimpleTest(() -> {
            runException("7200");
            assertThat(output()).contains("[ERROR]");
        });
    }

    @DisplayName("입력 받은 내용이 숫자인지 테스트")
    @Test
    void createLottoByIsNumber() {
        assertSimpleTest(() -> {
            runException("7200j");
            assertThat(output()).contains("[ERROR]");
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}