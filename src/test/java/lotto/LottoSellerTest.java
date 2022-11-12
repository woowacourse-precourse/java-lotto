package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static lotto.Constant.ERROR_INPUT_PAY_AMOUNT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoSellerTest {
    private LottoSeller purchase;

    @BeforeEach
    void setUp() {
        purchase = new LottoSeller();
    }

    @Test
    void 구입금액에_따른_로또개수_테스트() {
        purchase.payAmount = 8000;
        assertThat(purchase.countTicket()).isEqualTo(8);
    }
    @Test
    void 예외_테스트() {
        purchase.payAmount = 8100;

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                purchase.countTicket());
        assertEquals(ERROR_INPUT_PAY_AMOUNT, exception.getMessage());
    }
}