package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
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
        assertThat(rateOfReturn).isEqualTo(500.0);
    }

    @Test
    @DisplayName("로또에 당첨될 경우, 맞은 등수의 개수에 따라 오름차순 정렬할 수 있습니다.")
    void testLottoRanksSortedByCount() throws Exception {
        //given
        Map<LottoRank, Integer> lottoScore = new HashMap<>();

        lottoScore.put(LottoRank.FIRST, 3);
        lottoScore.put(LottoRank.FOURTH, 1);
        lottoScore.put(LottoRank.SECOND, 2);

        lottoResult = new LottoResult(lottoScore);

        //when
        List<LottoRank> result = lottoResult.getLottoRanksSortedByCount();

        //then
        assertThat(result).containsExactly(LottoRank.FOURTH, LottoRank.SECOND, LottoRank.FIRST);
    }
}