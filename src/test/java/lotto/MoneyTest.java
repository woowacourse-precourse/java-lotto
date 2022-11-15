package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    private Money money;

    @DisplayName("금액이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createMoneyNotNumeric() {
        assertThatThrownBy(() -> Money.from("5000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원보다 작다면 예외가 발생한다.")
    @Test
    void createMoneySmallerThanLottoPrice() {
        assertThatThrownBy(() -> Money.from("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원으로 나누어 떨어지지 않는다면 예외가 발생한다.")
    @Test
    void createMoneyNotDivisibleByLottoPrice() {
        assertThatThrownBy(() -> Money.from("5500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("amount(3000) / LottoPrice(1000)인 3을 반환한다.")
    @Test
    void getCountOfLottoByMoney() {
        money = Money.from("3000");
        assertThat(money.getCountOfLotto()).isEqualTo(3);
    }

    @DisplayName("수익률을 문자열로 반환한다.")
    @Test
    void calculateProfitRateByMoney() {
        money = Money.from("8000");
        assertThat(money.calculateProfitRate(5000)).isEqualTo("62.5");

        money = Money.from("10000");
        assertThat(money.calculateProfitRate(10000)).isEqualTo("100");
    }

    @DisplayName("수익률을 소수점 둘째 자리에서 반올림하여 반환한다.")
    @Test
    void calculateRoundedProfitRateByMoney() {
        money = Money.from("3000");
        assertThat(money.calculateProfitRate(5000)).isEqualTo("166.67");
    }
}