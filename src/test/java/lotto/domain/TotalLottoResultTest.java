package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.constants.ErrorMessage;
import lotto.domain.constants.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class TotalLottoResultTest {
    @DisplayName("주어진 당첨 내역의 등수 목록이 등수 정보와 일치하지 않는 경우 예외가 발생")
    @Test
    void createTotalLottoResultByIllegalRankedCounts() {
        Map<LottoRank, Integer> illegalRankedCounts = new HashMap<>(Map.of(
                LottoRank.RANK_1, 0, LottoRank.RANK_2, 1
        ));
        assertThatThrownBy(() -> new TotalLottoResult(illegalRankedCounts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RESULT_RANK_ILLEGAL.getValue());
    }

    @DisplayName("주어진 등수 별 개수의 총합이 낙첨 포함 0인 경우 예외가 발생")
    @Test
    void createTotalLottoResultByNotCountedRankings() {
        Map<LottoRank, Integer> illegalRankedCounts = new HashMap<>(Map.of(
                LottoRank.RANK_1, 0, LottoRank.RANK_2, 0,
                LottoRank.RANK_3, 0, LottoRank.RANK_4, 0,
                LottoRank.RANK_5, 0, LottoRank.RANK_LOSE, 0
        ));
        assertThatThrownBy(() -> new TotalLottoResult(illegalRankedCounts))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RESULT_RANK_NOT_COUNTED.getValue());
    }
}