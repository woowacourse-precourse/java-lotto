package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.enums.LottoRanking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoHistoryTest {
    private LottoHistory history;

    @BeforeEach
    void beforeEach() {
        history = new LottoHistory();
    }

    @DisplayName("당첨 내역 저장기능 테스트")
    @Test
    void saveHistoryTest() {
        // given
        String third = "THIRD";
        String fourth = "FOURTH";

        // when
        history.saveHistory(third);
        history.saveHistory(fourth);
        List<LottoRanking> winningHistory = history.getWinningHistory();

        // then
        assertThat(winningHistory).contains(LottoRanking.THIRD, LottoRanking.FOURTH);
    }

    @DisplayName("수익률 계산기능 테스트")
    @Test
    void getYieldTest() {
        // given
        long total = 5000;
        String amount = "8000";

        // when
        String yield = history.getYield(total, amount);

        // then
        assertThat(yield).isEqualTo("62.5");
    }
}