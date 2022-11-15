package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoShopTest {
    @DisplayName("금액을 입력하면 금액이 0이 될 때까지 로또를 구매한다.")
    @Test
    void purchaseLotto() {
        Money money = new Money(3000);

        List<Lotto> lottos = LottoShop.purchase(money);

        assertThat(lottos.size()).isEqualTo(3);
    }
}
