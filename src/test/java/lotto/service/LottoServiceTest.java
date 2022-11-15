package lotto.service;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또 구매 금액에 따른 개수를 반환한다.")
    void getPurchaseCountTest() {
        // given
        int purchaseAmount = 8000;

        // when
        int purchaseCount = lottoService.getPurchaseCount(purchaseAmount);

        // then
        assertThat(purchaseCount).isEqualTo(purchaseAmount / LOTTO_PRICE);
    }

    @Test
    @DisplayName("구입 금액에 따라 알 맞은 개수의 로또를 생성한다")
    void purchaseLottosTest() {
        // given
        int purchaseAmount = 8000;

        // when
        List<Lotto> lottos = lottoService.purchaseLottos(purchaseAmount);

        // then
        assertThat(lottos.size()).isEqualTo(purchaseAmount / LOTTO_PRICE);
    }
}