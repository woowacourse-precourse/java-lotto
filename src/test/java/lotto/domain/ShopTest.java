package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShopTest {
    @DisplayName("1000원은 1개의 로또를 발행한다")
    @Test
    void checkLottoPurchasingQuantity1() {
        assertThat(new Shop(new Money(1000)).buyLotto().size()).isEqualTo(1);
    }

    @DisplayName("2000원은 2개의 로또를 발행한다")
    @Test
    void checkLottoPurchasingQuantity2() {
        assertThat(new Shop(new Money(2000)).buyLotto().size()).isEqualTo(2);
    }

    @DisplayName("3000원은 3개의 로또를 발행한다")
    @Test
    void checkLottoPurchasingQuantity3() {
        assertThat(new Shop(new Money(30000)).buyLotto().size()).isEqualTo(30);
    }
}