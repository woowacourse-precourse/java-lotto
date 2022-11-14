package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameServiceTest {

    private LottoGameService lottoGameService;

    @BeforeEach
    void init() {
        this.lottoGameService = new LottoGameService();
    }
    @DisplayName("구입 금액에 맞춰 구매 가능한 로또 갯수를 반환한다.")
    @Test
    void buyLottoTickets() {
        int expect = 8;
        String purchaseAmount = "8000";
        int actual = lottoGameService.buyLottoTickets(purchaseAmount);
        assertThat(expect).isEqualTo(actual);
    }
}
