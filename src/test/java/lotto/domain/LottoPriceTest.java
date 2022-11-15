package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPriceTest {

    @DisplayName("로또 가격 받아오기")
    @Test
    void setAndGetLottoPrice() {
        LottoPrice lottoPrice = new LottoPrice(3000);
        assertThat(lottoPrice.getLottoPrice()).isEqualTo(3000);
    }

    @DisplayName("로또 티켓 구매 가능 수 출력")
    @Test
    void printLottoTicketCount() {
        LottoPrice lottoPrice = new LottoPrice(3000);
        assertThat(lottoPrice.lottoTicketCount()).isEqualTo(3);
    }
}