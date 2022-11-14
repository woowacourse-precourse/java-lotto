package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShopTest {
    @DisplayName("구입한 금액에 맞는 양의 로또를 발행한다1.")
    @Test
    void checkLottoPurchasingQuantity1() {
        assertThat(new Shop(new Money(1000)).buyLotto().size()).isEqualTo(1);
    }

    @DisplayName("구입한 금액에 맞는 양의 로또를 발행한다2.")
    @Test
    void checkLottoPurchasingQuantity2() {
        assertThat(new Shop(new Money(2000)).buyLotto().size()).isEqualTo(2);
    }

    @DisplayName("구입한 금액에 맞는 양의 로또를 발행한다3.")
    @Test
    void checkLottoPurchasingQuantity3() {
        assertThat(new Shop(new Money(30000)).buyLotto().size()).isEqualTo(30);
    }
}