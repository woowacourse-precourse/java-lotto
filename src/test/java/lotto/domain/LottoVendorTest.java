package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.domain.LottoVendor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoVendorTest {
    LottoVendor lottoVendor = new LottoVendor();

    @DisplayName("원하는 개수 만큼의 로또를 발행하는지 확인")
    @Test
    void lottoVendorSellAmountLottoTicket() {
        assertThat(lottoVendor.sale(5).size()).isEqualTo(5);
    }
}