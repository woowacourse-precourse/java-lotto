package lotto.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsumerTest {

    @DisplayName("구매 금액이 정해진 금액으로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void invalidPurchaseAmount() {
        //given
        int purchaseAmount = LottoConstant.PRICE.getValue() / 2;

        //then
        assertThatThrownBy(() -> new Consumer(purchaseAmount)).isInstanceOf(
            IllegalArgumentException.class);
    }

}