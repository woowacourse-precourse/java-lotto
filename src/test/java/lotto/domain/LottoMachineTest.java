package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.LottoMachine;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    @DisplayName("구매 금액 입력 시 숫자가 아닌 값을 입력하면 예외 발생")
    @Test
    void InputNonNumericValue() {
        LottoMachine machine = new LottoMachine();
        assertThatThrownBy(() -> machine.buy("1000k"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}