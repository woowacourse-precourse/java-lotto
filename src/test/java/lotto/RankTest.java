package lotto;

import lotto.domain.Compare;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    static Rank rank = Rank.None;

    @DisplayName("로또 등수 확인 테스트")
    @Test
    void lottoRankCheck() {
        // 2등 테스트
        rank = Rank.valueOf(5, true);
        assertThat(rank).isEqualTo(Rank.Two);
        // 3등 테스트
        rank = Rank.valueOf(5, false);
        assertThat(rank).isEqualTo(Rank.Three);
    }
}