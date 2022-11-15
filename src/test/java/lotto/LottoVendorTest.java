package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoVendorTest {
    LottoVendor lottoVendor = new LottoVendor();

    @DisplayName("구매할 만큼 로또가 발행되는가")
    @Test
    void lottoVendorSellAmountLottoTicket() {
        assertThat(lottoVendor.sale(5).size()).isEqualTo(5);
    }
}