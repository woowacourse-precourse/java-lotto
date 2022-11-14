package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    @DisplayName("correctCount와 isBonus 값으로 해당 LottoRank 값을 찾을 수 있다.")
    void findLottoRank_Success() {
        // Given
        LottoRank first = LottoRank.FIRST;
        int correctCount = first.getCorrectCount();
        boolean isBonus = first.isBonus();

        // When
        LottoRank lottoRank = LottoRank.findLottoRank(correctCount, isBonus);

        // Then
        assertThat(lottoRank).isEqualTo(first);
    }

    @Test
    @DisplayName("NONE을 제외한 모든 LottoRank 리스트를 얻을 수 있다.")
    void getLottoRankList_Success() {
        // Given // When
        List<LottoRank> lottoRanks = LottoRank.getLottoRankList();

        // Then
        assertThat(lottoRanks)
            .containsOnly(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.FOURTH, LottoRank.FIFTH);
    }
}