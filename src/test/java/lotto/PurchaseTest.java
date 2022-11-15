package lotto;

import lotto.domain.Purchase;
import lotto.ui.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseTest {

    @DisplayName("로또 구입 금액이 1,000원 단위가 아닌 경우 예외 발생")
    @Test
    void invalidMoney() {
        assertThatThrownBy(() -> new Purchase().isValid(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.MONEY_ERROR);
    }

    @Test
    void canBuyLottoTest() {
        int money = 14000;
        assertThat(new Purchase().canBuyLotto(money)).isEqualTo(14);
    }
}
