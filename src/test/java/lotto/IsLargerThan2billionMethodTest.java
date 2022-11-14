package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Application.isLargerThan2billion;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IsLargerThan2billionMethodTest {
    @Test
    void isLargerThan2billion_메소드_예외_테스트1() {
        Long numberInput = 2_000_000_001L;
        assertThatThrownBy(() -> isLargerThan2billion(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @Test
    void isLargerThan2billion_메소드_예외_테스트2() {
        Long numberInput = 999_999_999_999_999_999L;
        assertThatThrownBy(() -> isLargerThan2billion(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    @Test
    void isInputNumber_메소드_정상_입력_테스트1() {
        Long numberInput = 2_000_000_000L;
        isLargerThan2billion(numberInput);
    }
}