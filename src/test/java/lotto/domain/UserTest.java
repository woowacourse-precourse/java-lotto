package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @DisplayName("사용자의 입력 금액이 구매 단위와 다르면 예외가 발생한다")
    @Test
    void createWrongUnitMoney() {
        // given
        long money = 5500L;

        // when, then
        assertThatThrownBy(() -> new User(money, LottoMachine.order(money)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("투입 금액은 1000원이상, 1000단위의 숫자를 입력하세요.");
    }

    @DisplayName("입력 금액에 해당하는 수량의 로또를 가진다")
    @Test
    void getPurchasedLottoQuantity() {
        // given
        long money = 5000L;

        // when
        User user = new User(money, LottoMachine.order(money));

        // then
        assertThat(user.getLottos().size()).isEqualTo(user.getQuantity());
    }
}