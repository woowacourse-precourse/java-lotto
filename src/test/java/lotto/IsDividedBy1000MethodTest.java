package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Application.isDividedBy1000;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IsDividedBy1000MethodTest {
    @Test
    void isDividedBy1000_메소드_예외_테스트1() {
        Long numberInput = 1L;
        assertThatThrownBy(() -> isDividedBy1000(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액을 1000원 단위로 입력해 주세요.");
    }

    @Test
    void isDividedBy1000_메소드_예외_테스트2() {
        Long numberInput = 9L;
        assertThatThrownBy(() -> isDividedBy1000(numberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액을 1000원 단위로 입력해 주세요.");
    }

    @Test
    void isDividedBy1000_메소드_정상_입력_테스트1() {
        Long numberInput = 2_000_000_000L;
        isDividedBy1000(numberInput);
    }

    @Test
    void isDividedBy1000_메소드_정상_입력_테스트2() {
        Long numberInput = 0L;
        isDividedBy1000(numberInput);
    }
}