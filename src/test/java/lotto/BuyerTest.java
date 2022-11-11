package lotto;

import lotto.domain.Buyer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BuyerTest {
    @Test
    public void getBuyLottoCountTest() throws Exception{
        Buyer buyer = new Buyer(140000);
        assertThat(buyer.getBuyLottoCount()).isEqualTo(140);
    }
}