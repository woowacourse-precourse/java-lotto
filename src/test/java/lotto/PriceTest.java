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
}
