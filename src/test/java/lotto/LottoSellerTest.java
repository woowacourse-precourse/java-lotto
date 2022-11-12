package lotto;

import org.junit.jupiter.api.Test;

import static lotto.Constant.ERROR_INPUT_PAY_AMOUNT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoSellerTest {

    @Test
    void 구입금액에_따른_로또개수_테스트(){
        LottoSeller purchase = new LottoSeller();
        purchase.countTicket(8000);
        assertThat(purchase.numberOfTickets).isEqualTo(8);
    }
    @Test
    void 예외_테스트(){
        LottoSeller purchase = new LottoSeller();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                purchase.countTicket(8100));
        assertEquals(ERROR_INPUT_PAY_AMOUNT, exception.getMessage());
    }
}