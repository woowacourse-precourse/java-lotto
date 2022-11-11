package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {
    @DisplayName("구매 금액을 잘못 입력한 경우에는 예외가 발생한다.")
    @Test
    void enterPurchaseMoneyByInputFault() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("08000"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[Error] 구매 금액을 잘못 입력 하셨습니다.");
        });

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1abc"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[Error] 구매 금액을 잘못 입력 하셨습니다.");
        });
    }

    @DisplayName("구매 금액이 천 원으로 나누어 떨어지지 않는 경우에는 예외가 발생한다.")
    @Test
    void enterPurchaseMoneyByNotDivide() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("9999"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[Error] 구매 금액이 천 원으로 나누어 떨어지지 않는 금액입니다.");
        });
    }

    @DisplayName("당첨 번호를 쉼표로 구분할 수 없는 경우에는 예외가 발생한다")
    @Test
    void enterLottoByNotIdentify() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("8000", "1.2.3.4.5.6"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[Error] 당첨 번호가 구별되지 않습니다.");
        });
    }

    @DisplayName("입력한 당첨 번호들 중에서 숫자가 아닌 값이 있는 경우에는 예외가 발생한다.")
    @Test
    void enterLottoByNotNumber() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("8000", "1,a,10,3,4,5"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[Error] 당첨 번호 중에 숫자가 아닌 값이 존재합니다.");
        });
    }

    @DisplayName("입력된 당첨 번호 값들 중에서 1부터 45 사이아 값이 아닌 경우에는 예외가 발생한다.")
    @Test
    void checkLottoByInvalidRange() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("8000", "1,99,2,3,4,5"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[Error] 입력된 당첨 번호 값의 범위가 1부터 45 사이의 값이 아닙니다.");
        });
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
