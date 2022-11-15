package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTicketSellerTest {

    @DisplayName("돈으로 로또티켓을 구매")
    @ParameterizedTest
    @CsvSource(value = {"1000,1","10000,10","5000,5"})
    void buyLottoTicketTest(String money,int quantity) {
        assertThat(LottoTicketSeller.buyLottoByMoney(new LottoMoney(money))
                .getQuantity()).isEqualTo(quantity);
    }
}