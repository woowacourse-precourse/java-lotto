package lotto;

import static lotto.core.LottoRank._1st;
import static lotto.core.LottoRank._2nd;
import static lotto.core.LottoRank._3rd;
import static lotto.core.LottoRank._4th;
import static lotto.core.LottoRank._5th;
import static lotto.core.LottoRank.DRAW;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.core.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottoResultTest {
    @DisplayName("로또 등수별 기록의 순서를 반대로 한다.")
    @Test
    void sortTotalRankingResultTest() {
        LottoResult lottoResult = new LottoResult(List.of(_1st, DRAW, _3rd));

        lottoResult.sortTotalRankingResult((older, newer) ->
                Long.valueOf(newer.getKey().winningPrize).intValue()
                        - Long.valueOf(older.getKey().winningPrize).intValue()
        );

        assertThat(lottoResult.getTotalRankingResult().keySet()).containsExactly(_1st, _2nd, _3rd, _4th, _5th, DRAW);
        assertThat(lottoResult.getTotalRankingResult().values()).containsExactly(1, 0, 1, 0, 0, 1);
    }

    @DisplayName("로또 결과를 통해 로또 구입 금액을 구한다.")
    @Test
    void purchaseAmountTest() {
        LottoResult lottoResult = new LottoResult(List.of(_1st, DRAW, _3rd, _3rd));

        assertThat(lottoResult.getPurchaseAmount()).isEqualTo(4000);
    }

    @DisplayName("로또 결과를 통해 로또 등수별 기록을 구한다.")
    @Test
    void totalRankingResultTest() {
        LottoResult lottoResult = new LottoResult(List.of(_1st, DRAW, _3rd, _3rd));

        assertThat(lottoResult.getTotalRankingResult().keySet()).containsExactly(DRAW, _5th, _4th, _3rd, _2nd, _1st);
        assertThat(lottoResult.getTotalRankingResult().values()).containsExactly(1, 0, 0, 2, 0, 1);
    }

    @DisplayName("로또 결과를 통해 총 당첨 금액을 구한다.")
    @Test
    void totalPrizeTest() {
        LottoResult lottoResult = new LottoResult(List.of(_1st, DRAW, _3rd, _3rd, _1st, DRAW, _5th));

        assertThat(lottoResult.getTotalPrize()).isEqualTo(4_003_005_000L);
    }

    @DisplayName("로또 결과를 통해 구매 금액 대비 총 수익률을 구한다.")
    @Test
    void totalReturnRatioTest() {
        LottoResult lottoResult = new LottoResult(List.of(_4th, DRAW, _3rd, _3rd, _5th, _5th, _5th));

        assertThat(lottoResult.getTotalReturnRatio()).isEqualTo(43785.71);
    }
}