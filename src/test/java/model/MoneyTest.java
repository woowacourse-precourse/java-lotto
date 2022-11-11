package model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @ParameterizedTest(name = "{index}  money = {0}")
    @ValueSource(ints = {500, 1500, 999, 1001})
    void 구입_금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다(int money) {
        assertThatThrownBy(() -> {
            new Money(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1,000원으로 나누어 떨어져야 합니다.");
    }
}
