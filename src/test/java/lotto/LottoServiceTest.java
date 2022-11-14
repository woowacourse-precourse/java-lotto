package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @Test
    void purchaseLottoTest() {
        lottoService.purchase(new Money(5000));

        assertThat(lottoService.getPurchaseLotteries().size()).isEqualTo(5);
    }
}