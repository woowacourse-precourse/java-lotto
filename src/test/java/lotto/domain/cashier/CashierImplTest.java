package lotto.domain.cashier;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CashierImplTest {

    Cashier cashier = new CashierImpl();

    @Test
    void checkPublishLottoCountTest() {
        //given
        int paymentAmount = 14000;

        //when
        int publishedLottoCount = cashier.checkPublishLottoCount(paymentAmount);

        //then
        Assertions.assertThat(publishedLottoCount).isEqualTo(14);

    }

}
