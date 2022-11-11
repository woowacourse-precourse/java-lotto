package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    void 금액_단위_예외_테스트1() {
        assertThatThrownBy(() -> new Money(9500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    void 금액_단위_예외_테스트2() {
        assertThatThrownBy(() -> new Money(12345))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1,000원 단위여야 합니다.");
    }
}
