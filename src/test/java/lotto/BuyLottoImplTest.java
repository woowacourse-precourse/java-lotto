package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyLottoImplTest {

    BuyLotto buyLotto = new BuyLottoImpl(1500,15000);

    @Test
    void getLottoCount() {
        Assertions.assertThat(buyLotto.getLottoCount()).isEqualTo(10);
    }

    @Test
    void validate() {
    }

    @Test
    void buyLotto() {
    }

    @Test
    void getLottoNumber() {
    }
}