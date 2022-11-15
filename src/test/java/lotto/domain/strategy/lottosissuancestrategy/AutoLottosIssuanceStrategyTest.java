package lotto.domain.strategy.lottosissuancestrategy;

import lotto.domain.Lottos;
import lotto.domain.LottosTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottosIssuanceStrategyTest {
    @Test
    @DisplayName("자동 로또 발행")
    void issueLottos() {
        LottosIssuanceStrategy lottosIssuanceStrategy = new AutoLottosIssuanceStrategy() {
            @Override
            public Lottos issueLottos(final int numberOfLottoPurchased) {
                return LottosTest.LOTTOS;
            }
        };
        final Lottos lottos = lottosIssuanceStrategy.issueLottos(0);
        
        assertThat(lottos).isEqualTo(LottosTest.LOTTOS);
    }
}