package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShopTest {
    @DisplayName("구입한 금액에 맞는 수량만큼 로또를 발행한다.")
    @Test
    void checkLottoPurchasingQuantity() {
        assertThat(new Shop(new Money(1000)).buyLotto().size()).isEqualTo(1);
        assertThat(new Shop(new Money(2000)).buyLotto().size()).isEqualTo(2);
        assertThat(new Shop(new Money(30000)).buyLotto().size()).isEqualTo(30);
    }

}