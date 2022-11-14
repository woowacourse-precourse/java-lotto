package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.LottoRank.*;
import static org.assertj.core.api.Assertions.*;

class LottoResultTest {
    @DisplayName("로또 등수별 기록의 순서를 반대로 한다.")
    @Test
    void sortRankResultTest() {
        List<LottoRank> winningResult = List.of(_1st, DRAW, _3rd);
        LottoResult lottoResult = new LottoResult(winningResult, 3000);

        lottoResult.sortRankResult((older, newer) ->
                Long.valueOf(newer.getKey().winningPrize).intValue()
                        - Long.valueOf(older.getKey().winningPrize).intValue()
        );

        assertThat(lottoResult.getRankResult().keySet()).containsExactly(_1st, _2nd, _3rd, _4th, _5th, DRAW);
        assertThat(lottoResult.getRankResult().values()).containsExactly(1, 0, 1, 0, 0, 1);
    }

    @DisplayName("로또 결과를 통해 로또 등수별 기록을 구한다.")
    @Test
    void rankResultTest() {
        List<LottoRank> winningResult = List.of(_1st, DRAW, _3rd, _3rd);
        LottoResult lottoResult = new LottoResult(winningResult, 4000);

        assertThat(lottoResult.getRankResult().keySet()).containsExactly(DRAW, _5th, _4th, _3rd, _2nd, _1st);
        assertThat(lottoResult.getRankResult().values()).containsExactly(1, 0, 0, 2, 0, 1);
    }

    @DisplayName("로또 결과를 통해 총 당첨 금액을 구한다.")
    @Test
    void totalPrizeTest() {
        List<LottoRank> winningResult = List.of(_1st, DRAW, _3rd, _3rd, _1st, DRAW, _5th);
        LottoResult lottoResult = new LottoResult(winningResult, 7000);

        assertThat(lottoResult.getTotalPrize()).isEqualTo(4_003_005_000L);
    }

    @DisplayName("로또 결과를 통해 구매 금액 대비 총 수익률을 구한다.")
    @Test
    void totalReturnRatioTest() {
        List<LottoRank> winningResult = List.of(_4th, DRAW, _3rd, _3rd, _5th);
        LottoResult lottoResult = new LottoResult(winningResult, 5000);

        assertThat(lottoResult.getTotalReturnRatio()).isEqualTo(61100.0);
    }
}