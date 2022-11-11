package lotto.domain.money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {


    @ParameterizedTest(name = "주어진 값({argumentsWithNames})으로 생성된다.")
    @ValueSource(ints = {1_000, 5_000, 2_000_000_000, 2_147_483_647})
    void createMoney(final int value) {
        // when, then
        assertThat(Money.valueOf(value)).isNotNull();
    }

    @DisplayName("다른 단위의 Money로 교환테스트. [A를 B로 변환하면 C장이 나온다.]")
    @ParameterizedTest(name = "{displayName} {argumentsWithNames}")
    @CsvSource({"3_000, 1_000, 3", "10_000, 2_000, 5", "15_000, 500, 30"})
    void exchangeFor(final int value, final int exchangedValue, final int count) {
        // given
        Money money = Money.valueOf(value);
        Money exchangedMoney = Money.valueOf(exchangedValue);

        // when, then
        assertThat(money.exchangeFor(exchangedMoney).size())
                .isEqualTo(count);
    }

    @DisplayName("다른 단위의 Money로 교환시 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest(name = "{displayName} {argumentsWithNames}")
    @CsvSource({"3_000, 1_200", "11_000, 2_000, 5", "15_000, 16_000"})
    void exchangeFor(final int value, final int exchangedValue) {
        // given
        Money money = Money.valueOf(value);
        Money exchangedMoney = Money.valueOf(exchangedValue);

        // when, then
        assertThatThrownBy(() -> money.exchangeFor(exchangedMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }
}