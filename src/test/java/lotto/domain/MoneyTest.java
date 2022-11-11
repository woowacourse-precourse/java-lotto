package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("로또 구입 금액 단위가 아니면 예외를 발생한다.")
    void buyLottoEx() {
        Money money = new Money(12500);

        assertThatThrownBy(money::exchangeLotto).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액만큼 로또 갯수를 반환한다.")
    void buyLotto() {
        Money money = new Money(12000);

        int lottos = money.exchangeLotto();

        assertThat(lottos).isEqualTo(12);
    }
}