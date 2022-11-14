package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PriceTest {
    @DisplayName("숫자가 아니면 예외처리를 한다.")
    @Test
    void createPriceByNotNumber() {
        assertThatThrownBy(() -> new Price("hello"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Price("1a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위로 나누어 떨어지지 않으면 예외처리를 한다.")
    @Test
    void createPriceByUndividedNumber() {
        assertThatThrownBy(() -> new Price("1001"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Price("800"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
