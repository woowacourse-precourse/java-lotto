package lotto.domain.draw;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    @DisplayName("LottoResults는 LottoRanking의 모든 Elements를 갖고 있다.")
    @Test
    void keySetContainsAllLottoRankingElements() {
        LottoResults lottoResults = new LottoResults();
        Set<LottoRanking> lottoRankings = lottoResults.keySet();
        assertThat(lottoRankings).hasSize(LottoRanking.values().length);
    }
}