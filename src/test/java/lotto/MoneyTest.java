package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {-1200, 5340})
    @DisplayName("로또 구입 금액이 최소 구입 금액 이하이거나 1,000원 단위가 아니라면 예외를 발생시킨다.")
    void createLottoMoney(int money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}