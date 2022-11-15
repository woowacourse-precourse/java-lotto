package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchasingLottoListTest {

    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않은면 예외가 발생한다.")
    @Test
    void moneyToTicket() {
        assertThatThrownBy(() -> new PurchasingLottoList(13400).moneyToTicket(13400))
                .isInstanceOf(IllegalArgumentException.class);
    }
}