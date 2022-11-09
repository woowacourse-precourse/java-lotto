package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(strings = {"ㄱㄴㄷ", "abc", "-1", "-10", "10", "100"})
    void 금액은_1000원_단위로_나누어_떨어지는_양수만_가능하다(String money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}