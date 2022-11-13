package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinRankTest {
    @DisplayName("로또 당첨 등수가 정확하게 나온다.")
    @Test
    void Rank_Test1() {
        assertThat(WinRank.calculateRankOfLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
                , new Lotto(List.of(3, 4, 5, 6, 7, 8))
                , 1)).isEqualTo(WinRank.FOURTH);
    }

    @Test
    void Rank_Test2() {
        assertThat(WinRank.calculateRankOfLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
                , new Lotto(List.of(7, 8, 9, 10, 11, 12))
                , 1)).isEqualTo(WinRank.FAIL);
    }

    @DisplayName("보너스 번호가 등수에 알맞게 집계된다.")
    @Test
    void Rank_Test3() {
        assertThat(WinRank.calculateRankOfLotto(
                new Lotto(List.of(1, 7, 3, 4, 5, 6))
                , new Lotto(List.of(3, 4, 5, 6, 7, 8))
                , 10)).isEqualTo(WinRank.THIRD);
    }

    @Test
    void Rank_Test4() {
        assertThat(WinRank.calculateRankOfLotto(
                new Lotto(List.of(1, 7, 3, 4, 5, 6))
                , new Lotto(List.of(3, 4, 5, 6, 7, 8))
                , 1)).isEqualTo(WinRank.SECOND);
    }
}
