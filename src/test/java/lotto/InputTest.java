package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {
    @DisplayName("구입금액을 숫자가 아닌 다른 값으로 입력시 예외가 발생한다.")
    @Test
    void 숫자가_아닌_값으로_구입금액입력_시_예외_발생() {
        assertThatThrownBy(() -> runException("one hundred"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 아닌 다른 값을 입력하였습니다.");
    }

    @DisplayName("구입금액 1000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void 구입금액이_1000원으로_나누어_떨어지지_않는_경우_예외_발생() {
        assertThatThrownBy(() -> runException("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 금액 단위입니다.");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
