package lotto.domain.strategy.lottosissuancestrategy;

import lotto.domain.Lottos;
import lotto.domain.LottosTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosIssuanceStrategyTest {
    
    @Test
    @DisplayName("자동 로또 발행")
    void issueLottos() {
        LottosIssuanceStrategy lottosIssuanceStrategy = numberOfLottoPurchased -> LottosTest.LOTTOS;
        final Lottos lottos = lottosIssuanceStrategy.issueLottos(0);
        
        assertThat(lottos).isEqualTo(LottosTest.LOTTOS);
    }
}