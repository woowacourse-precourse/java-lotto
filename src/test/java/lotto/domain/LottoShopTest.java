package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoShopTest {

    @DisplayName("구입 금액이 1,000원이면 로또 1개를 발행한다.")
    @Test
    void createLottoByMoney1000() {
        assertThat(new LottoShop(new Money(1000)).buyLotto().size())
                .isEqualTo((1));
    }

    @DisplayName("구입 금액이 2,000원이면 로또 2개를 발행한다.")
    @Test
    void createLottoByMoney2000() {
        assertThat(new LottoShop(new Money(2000)).buyLotto().size())
                .isEqualTo((2));
    }

}