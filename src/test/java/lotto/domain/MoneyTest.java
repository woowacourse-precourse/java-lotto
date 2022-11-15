package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Money 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MoneyTest {

    @Test
    void ZERO는_0원을_의미한다() {
        Money money = Money.ZERO;
        assertThat(money).isEqualTo(new Money(0L));
    }

    @Test
    void wons_메서드는_금액을_입력받아_Money의_인스턴스를_반환한다() {
        Money money = Money.wons(1000L);
        assertThat(money).isEqualTo(new Money(1000L));
    }

    @Test
    void getAmount_메서드는_Long_타입의_값을_반환한다() {
        Money money = Money.wons(1000L);
        assertThat(money.getAmount()).isEqualTo(1000L);
    }

    @Test
    void plus_메서드는_Money를_입력받아_합을_반환한다() {
        Money money1 = Money.wons(1000L);
        Money money2 = Money.wons(1500L);

        assertThat(money1.plus(money2)).isEqualTo(new Money(2500L));
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({"1500, 2, 3000", "1000, 100, 100000", "8000, 5, 40000"})
    void times_메서드는_곱하는_수를_입력받아_곱을_반환한다(long amount, long times, long result) {
        Money money = Money.wons(amount);

        assertThat(money.times(times)).isEqualTo(Money.wons(result));
    }

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({"1500, 500, 3", "1000, 1500, 0.6666666666666666", "8000, 5000, 1.6"})
    void divide_메서드는_Money를_입력받아_몫을_반환한다(long amount1, long amount2, double result) {
        Money money1 = Money.wons(amount1);
        Money money2 = Money.wons(amount2);

        assertThat(money1.divide(money2)).isEqualTo(result);
    }

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({"1500, 500, 3", "1000, 1500, 0", "8000, 5000, 1"})
    void floorDivide_메서드는_Money를_입력받아_버림나눗셈하여_반환한다(long amount1, long amount2, long result) {
        Money money1 = Money.wons(amount1);
        Money money2 = Money.wons(amount2);

        assertThat(money1.floorDivide(money2)).isEqualTo(result);
    }

    @ParameterizedTest(name = "{0} % {1} = {2}")
    @CsvSource({"1500, 500, 0", "8000, 1000, 0", "8001, 1000, 1"})
    void calculateRemainder_메서드는_입력받은_수로_나눴을_때의_나머지를_반환한다(
            long amount1,
            long amount2,
            long result
    ) {
        Money money1 = Money.wons(amount1);
        Money money2 = Money.wons(amount2);

        assertThat(money1.calculateRemainder(money2)).isEqualTo(Money.wons(result));
    }

    @ParameterizedTest(name = "{0} >= {1} = {2}")
    @CsvSource({"20000, 19999, true", "20000, 20000, true", "20000, 20001, false"})
    void isGreaterThanOrEqual_메서드는_비교금액_이상의_경우_true_미만의_경우_false를_반환한다(
            long amount1,
            long amount2,
            boolean result
    ) {
        Money money1 = Money.wons(amount1);
        Money money2 = Money.wons(amount2);

        assertThat(money1.isGreaterThanOrEqual(money2)).isEqualTo(result);
    }
}
