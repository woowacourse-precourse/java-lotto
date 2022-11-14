package lotto;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 번호는 ")
class NumberTest {

    @Test
    @DisplayName("1보다 작은 값을 가질 수 없다.")
    void lowerValueRange() {
        int number = 0;
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("45보다 큰 값을 가질 수 없다.")
    void upperValueRange() {
        int number = 0;
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}