package lotto.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    @Test
    @DisplayName("2등에 해당하는 결과를 반환한다.")
    void createSecondRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        winningNumber winningNumber = new winningNumber(winningLotto, 6);

        // when
        rank Rank = rank.calculate(lotto, winningNumber);

        // then
        assertThat(Rank.getPrize()).isEqualTo(rank.SECOND.getPrize());
    }

    @Test
    @DisplayName("3등에 해당하는 결과를 반환한다.")
    void createThirdRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        winningNumber winningNumber = new winningNumber(winningLotto, 40);

        // when
        rank Rank = rank.calculate(lotto, winningNumber);

        // then
        assertThat(Rank.getPrize()).isEqualTo(rank.THIRD.getPrize());
    }

    @Test
    @DisplayName("1 ~ 5등 총 5개의 유효한 결과를 반환한다")
    void createValidRanks() {
        // given
        int expected = 5;
        List<rank> validRanks = rank.getValidRanks();

        // when, then
        assertThat(validRanks.size()).isEqualTo(expected);
    }

    @Test
    @DisplayName("해당 게임의 수익을 반환한다")
    void createEarning() {
        // given
        winningNumber winningNumber = new winningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10);
        Lotto threeMatchedLotto = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        int expectedEarning = rank.FIFTH.getPrize();

        // when
        rank Rank = rank.calculate(threeMatchedLotto, winningNumber);
        long calculateEarning = rank.calculateEarning(Collections.singletonList(Rank));

        // then
        assertThat(calculateEarning).isEqualTo(expectedEarning);
    }

    @Test
    @DisplayName("해당 등수가 몇 개 있는지 반환한다.")
    void createAccordingRankCount() {
        // given
        winningNumber winningNumber = new winningNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10);
        Lotto threeMatchedLotto = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        int expectedCount = 1;

        // when
        rank Rank = rank.calculate(threeMatchedLotto, winningNumber);
        long calculateCount = Rank.calculateCount(Collections.singletonList(Rank));

        // then
        assertThat(calculateCount).isEqualTo(expectedCount);
    }
}