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

    @Test
    void calculateRateOfReturnTest() {
        //given
        int paymentAmount = 17000;
        int totalPrizeMoney = 5000;

        //when
        double rateOfReturn = cashier.calculateRateOfReturn(paymentAmount, totalPrizeMoney);

        //then
        Assertions.assertThat(rateOfReturn).isEqualTo(29.4);

    }

}
