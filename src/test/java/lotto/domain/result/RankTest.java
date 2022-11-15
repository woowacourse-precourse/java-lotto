package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @Test
    @DisplayName("알맞은 Rank 를 가져옵니다 - 3개 매칭")
    void getRank_3hits() {
        assertThat(Rank.getRank(3, false))
                .isEqualTo(Rank.THREE_MATCHES);
    }

    @Test
    @DisplayName("알맞은 Rank 를 가져옵니다 - 4개 매칭")
    void getRank_4hits() {
        assertThat(Rank.getRank(4, false))
                .isEqualTo(Rank.FOUR_MATCHES);
    }

    @Test
    @DisplayName("알맞은 Rank 를 가져옵니다 - 5개 매칭 & 보너스 매칭")
    void getRank_5hits_with_bonus() {
        assertThat(Rank.getRank(5, true))
                .isEqualTo(Rank.FIVE_MATCHES_WITH_BONUS);
    }

    @Test
    @DisplayName("알맞은 Rank 를 가져옵니다 - 5개 매칭")
    void getRank_5hits() {
        assertThat(Rank.getRank(5, false))
                .isEqualTo(Rank.FIVE_MATCHES_WITHOUT_BONUS);
    }

    @Test
    @DisplayName("알맞은 Rank 를 가져옵니다 - 6개 매칭")
    void getRank_6hits() {
        assertThat(Rank.getRank(6, false))
                .isEqualTo(Rank.SIX_MATCHES);
    }

    @Test
    @DisplayName("알맞은 Rank 를 가져옵니다 - 2개 이하 매칭")
    void getRank_none() {
        assertThat(Rank.getRank(2, false))
                .isEqualTo(Rank.NONE);
    }

    @Test
    @DisplayName("유효하지 않은 타입을 요청합니다")
    void getRank_invalid_type() {
        assertThat(Rank.getRank(10, false))
                .isEqualTo(Rank.NONE);
    }
}