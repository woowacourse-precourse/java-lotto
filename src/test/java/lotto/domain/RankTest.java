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

    @DisplayName("일치하는 번호가 없으면 Rank 결과는 NOTHING")
    @Test
    void findRankByMatchNothing() {
        Rank rank = Rank.findRankByMatch(2);
        Rank result = Rank.NOTHING;

        assertThat(result).isEqualTo(rank);
    }

    @DisplayName("Rank 출력 형식에 맞게 반환 성공")
    @Test
    void checkRankDataFormat() {
        Rank rank = Rank.SECOND_RANK;
        String result = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";

        assertThat(rank.toString()).isEqualTo(result);
    }
}
