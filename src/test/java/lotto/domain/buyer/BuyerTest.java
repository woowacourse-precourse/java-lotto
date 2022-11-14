package lotto.domain.buyer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyerTest {

    @DisplayName("[성공] 총 로또 당첨 금액과 로또 구매 금액을 통해 수익률 구하기")
    @Test
    void calculateProfitRatio() {
        List<Lotto> lottos = new ArrayList<>();
        Buyer buyer = new User(lottos);
        long profitRatio = buyer.calculateProfitRatio(5000);
        assertThat(profitRatio).isEqualTo(62.5);
    }
}
