package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
    void buyLotto() {
    }

    @Test
    void getLottoNumber() {
    }
}