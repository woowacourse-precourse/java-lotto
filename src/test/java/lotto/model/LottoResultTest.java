package lotto.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoResult Unit Test")
class LottoResultTest {

    LottoResult lottoResult;

    @Test
    @DisplayName("로또에 당첨될 경우, 총 당첨 금액을 구할 수 있습니다.")
    void testGetAllReward() throws Exception {
        //given
        Map<LottoRank, Integer> lottoScore = new HashMap<>();

        lottoScore.put(LottoRank.SECOND, 2);
        lottoScore.put(LottoRank.THIRD, 1);
        lottoScore.put(LottoRank.FOURTH, 1);
        lottoScore.put(LottoRank.NONE, 5);

        lottoResult = new LottoResult(lottoScore);

        //when
        long totalReward = lottoResult.getTotalReward();

        //then
        assertThat(totalReward).isEqualTo(61_550_000);
    }

    @Test
    @DisplayName("로또에 당첨될 경우, 수익률을 구할 수 있습니다.")
    void testGetRateOfReturn() throws Exception {
        //given
        Map<LottoRank, Integer> lottoScore = new HashMap<>();

        lottoScore.put(LottoRank.FOURTH, 1);
        lottoScore.put(LottoRank.NONE, 5);

        lottoResult = new LottoResult(lottoScore);

        //when
        double rateOfReturn = lottoResult.getRateOfReturn(10000);

        //then
        assertThat(rateOfReturn).isEqualTo(50.0);
    }
}