package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {

    @DisplayName("1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.")
    @Test
    void divideBy1000Validate() {
        Input input = new Input();
        assertThatThrownBy(() -> input.validate(8500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}