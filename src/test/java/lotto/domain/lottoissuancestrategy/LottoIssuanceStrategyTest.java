package lotto.domain.lottoissuancestrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoIssuanceStrategyTest {
    @Test
    @DisplayName("로또 발행 되는지 확인")
    void issueLotto() {
        LottoIssuanceStrategy lottoIssuanceStrategy = () -> List.of(1, 20, 31, 35, 40, 45);
        assertThat(lottoIssuanceStrategy.issueLotto()).isEqualTo(List.of(1, 20, 31, 35, 40, 45));
    }
}