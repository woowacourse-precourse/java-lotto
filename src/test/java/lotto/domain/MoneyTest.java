package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("로또 구입 금액 단위가 아니면 예외를 발생한다.")
    @Test
    void buyLottoEx() {
        Money money = Money.of(12500);

        assertThatThrownBy(money::exchangeLotto).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액만큼 로또 갯수를 반환한다.")
    @Test
    void buyLotto() {
        Money money = Money.of(12000);

        int lottos = money.exchangeLotto();

        assertThat(lottos).isEqualTo(12);
    }

    @DisplayName("금액끼리 나눈다.")
    @Test
    void divide() {
        Money money = Money.of(10);
        Money other = Money.of(2);

        double result = money.divide(other);

        assertThat(result).isEqualTo(5);
    }
}