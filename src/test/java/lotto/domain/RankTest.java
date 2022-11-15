package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @DisplayName("일치하는 번호 개수로 Rank 찾기 성공")
    @Test
    void findRankByMatchNumber() {
        Rank rank = Rank.findRankByMatch(3);
        Rank result = Rank.FIFTH_RANK;

        assertThat(result).isEqualTo(rank);
    }
}
