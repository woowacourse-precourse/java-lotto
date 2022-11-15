package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoWinningResultTest {

    LottoWinningResult winningResults;

    @BeforeEach
    void init() {
        winningResults = new LottoWinningResult();
    }

    @Test
    void 당첨횟수잘가져오는지확인() {
        int result = winningResults.getWinningResult(LottoRank.FIRST_PRIZE);
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void 당첨횟수업데이트잘되는지확인() {
        winningResults.updateWinningResult(LottoRank.FIRST_PRIZE);
        int result = winningResults.getWinningResult(LottoRank.FIRST_PRIZE);
        Assertions.assertThat(result).isEqualTo(1);
    }
}