package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStaticsTest {

    WinningStatics winningStatics;

    @BeforeEach
    void setup() {
        winningStatics = new WinningStatics();
    }

    @DisplayName("총 당첨금액으로 수익율을 계산한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 40000, 1000000})
    void 수익율_계산(int purchaseMoney) {
        winningStatics.updateLottoResults(LottoResult.FIFTH);
        winningStatics.calculateRateOfReturn(purchaseMoney);

        long prizeMoney = LottoResult.FIFTH.calculatePrizeMoney(1);
        float rateOfReturn = Math.round((float) prizeMoney / purchaseMoney * 1000) / 10f;
        assertThat(winningStatics)
                .extracting("rateOfReturn")
                .isEqualTo(rateOfReturn);
    }
}