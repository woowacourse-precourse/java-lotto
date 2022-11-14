package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.LottoMachine;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    LottoMachine machine = new LottoMachine();
    @DisplayName("구매 금액 입력 시 숫자가 아닌 값을 입력하면 예외 발생")
    @Test
    void InputNonNumericValue() {
        assertThatThrownBy(() -> machine.getLottoBundle("1000k"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않으면 예외 발생")
    @Test
    void InputNonDivisibleNumber() {
        assertThatThrownBy(() -> machine.getLottoBundle("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 개수가 정확한지 테스트")
    @Test
    void TestNumberOfPurchases() {
        String[] input = {
                "1000",
                "3000",
                "7000",
                "12000"
        };
        int[] results = {
                1,
                3,
                7,
                12
        };
        for (int i = 0; i < input.length; i++) {
            int count = machine.getLottoBundle(input[i]).size();
            assertThat(count).isEqualTo(results[i]);
        }
    }
}