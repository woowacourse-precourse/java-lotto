package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {

    @DisplayName("금액이 음수면 예외를 발생시킨다")
    @Test
    void negative_money_throws_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(-1000));
    }

    @ParameterizedTest(name = "{0}으로 {1}짜리를 사면 잔돈이 생긴다={2}")
    @CsvSource(value = {"15000,1500,false", "10000,1100,true"}, delimiter = ',')
    void decide_whether_changes_are_made_by_price(int amount, int price, boolean expected) {
        assertThat(new Money(amount).hasChangesWith(price)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0}으로 {1}짜리를 {2}개 살 수 있다")
    @CsvSource(value = {"15000,1500,10", "10000,1100,9"}, delimiter = ',')
    void count_affordable_by_price(int amount, int price, int expected) {
        assertThat(new Money(amount).countAffordableFor(price)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "금액 {0} + 금액 {1} = {2}")
    @CsvSource(value = {"15000,1500,16500", "10000,1100,11100"}, delimiter = ',')
    void add_money(int amount, int otherAmount, int expected) {
        Money addedMoney = new Money(amount).add(new Money(otherAmount));

        assertThat(addedMoney).isEqualTo(new Money(expected));
    }

    @DisplayName("수익률을 계산한다")
    @Test
    void calculate_profit_rate() {
        Money spent = new Money(8000);
        Money earned = new Money(5000);

        assertThat(spent.calculateProfitRateOf(earned)).isEqualTo(62.5);
    }
}
