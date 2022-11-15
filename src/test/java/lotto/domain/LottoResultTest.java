package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
        lottoResult.add(LottoRank.THIRD);
        lottoResult.add(LottoRank.THIRD);
    }

    @DisplayName("수익의 총합을 반환할 수 있다. ")
    @Test
    void 수익의_총합_계산하기() {
        //given

        //when
        int totalProfit = lottoResult.getTotalProfit();
        //then
        assertThat(totalProfit).isEqualTo(3000000);
    }

    @DisplayName("수익의 총합과 로또 구입금이 주어졌을 때 수익률을 계산할 수 있다.")
    @Test
    void 수익률_계산() {
        double rateOfProfit = lottoResult.getRateOfProfit(10000);
        assertThat(rateOfProfit).isEqualTo(30000.0);
    }

}