package lotto.domain.winning;

import static lotto.domain.winning.LottoRanking.FIFTH;
import static lotto.domain.winning.LottoRanking.FIRST;
import static lotto.domain.winning.LottoRanking.FORTH;
import static lotto.domain.winning.LottoRanking.SECOND;
import static lotto.domain.winning.LottoRanking.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    @DisplayName("1,2,3등이 각각 한개씩 당첨됐을 경우, 총 당첨 금액은 2_031_500_000이다")
    @Test
    void totalWinnings() {
        Map<LottoRanking, Integer> results = Map.of(
                FIFTH, 0,
                FORTH, 0,
                THIRD, 1,
                SECOND, 1,
                FIRST, 1
        );

        int expected = 2_031_500_000;

        LottoResults lottoResults = new LottoResults(results);
        assertThat(lottoResults.totalWinnings()).isEqualTo(expected);
    }
}