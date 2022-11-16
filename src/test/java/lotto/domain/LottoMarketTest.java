package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMarketTest {

    @DisplayName("구입 금액에 맞게 로또 티켓들을 발행한다.")
    @Test
    void createLottoTicketsForNormal() {
        // given
        int money = 8000;
        LottoMarket lottoMarket = new LottoMarket();

        // when & then
        assertThatCode(() -> lottoMarket.buy(new Wallet(money)))
                .doesNotThrowAnyException();
    }
}
