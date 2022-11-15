package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

class BuyLottoImplTest {

    BuyLotto buyLotto = new BuyLottoImpl(1500,15000);
    BuyLotto buyLottoNoDivide = new BuyLottoImpl(1200,15000);
    @Test
    void getLottoCount() {
        assertThat(buyLotto.getLottoCount()).isEqualTo(10);
    }

    @Test
    void validate() {
        assertThatThrownBy(()->buyLottoNoDivide.validate()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getLottos() {
        ArrayList<Lotto> lottos = buyLotto.getLottos();
        assertThat(lottos.size()).isEqualTo(buyLotto.getLottoCount());
    }
}