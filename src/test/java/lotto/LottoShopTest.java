package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoShopTest {
    @DisplayName("로또 금액을 입력하면 금액을 1,000으로 나눈 수 만큼 로또를 생성한다.")
    @Test
    void purchaseLotto() {
        int money = 3000;
        int lottoPrice = 1000;
        int quantity = money / lottoPrice;

        List<Lotto> lottos = LottoShop.purchase(money);

        assertThat(lottos.size()).isEqualTo(quantity);
    }
}
