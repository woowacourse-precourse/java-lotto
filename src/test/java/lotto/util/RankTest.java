package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @DisplayName("로또 번호를 맞힌 개수대로 등수를 반환한다.")
    @Test
    void getRankByMatchCount() {
        int matchCount = 5;
        boolean isBonusNumberMatched = false;

        assertThat(Rank.getRankByMatchCount(matchCount, isBonusNumberMatched))
                .isEqualTo(Rank.THIRD);
    }
}