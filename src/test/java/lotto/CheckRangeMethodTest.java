package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Application.checkRange;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CheckRangeMethodTest {
    private static final String ERROR_MESSAGE = "[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.";

    @Test
    void checkRange_메소드_정상_입력_테스트1() {
        for (int number = 1; number <= 45; number++)
            checkRange(number);
    }

    @Test
    void checkRange_메소드_예외_테스트1() {
        assertThatThrownBy(() -> checkRange(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void checkRange_메소드_예외_테스트2() {
        assertThatThrownBy(() -> checkRange(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}