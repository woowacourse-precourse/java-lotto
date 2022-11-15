package lotto.domain.strategy.lottoissuancestrategy;

import lotto.domain.Lotto;
import lotto.domain.LottoTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoIssuanceStrategyTest {
    @Test
    @DisplayName("로또 발행 되는지 확인")
    void issueLotto() {
        LottoIssuanceStrategy lottoIssuanceStrategy = new RandomLottoIssuanceStrategy() {
            @Override
            public Lotto issueLotto() {
                return LottoTest.FROM_ONE_TO_SIX;
            }
        };
        assertThat(lottoIssuanceStrategy.issueLotto()).isEqualTo(LottoTest.FROM_ONE_TO_SIX);
    }
}