package lotto;

import static lotto.LottoRank.RANK1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {
    @DisplayName("당첨 번호와 6개가 일치할 경우 RANK1이다")
    @Test
    void findRank() {
        LottoRank rank = LottoRank.findRank(6);
        Assertions.assertThat(rank).isEqualTo(RANK1);
    }
}