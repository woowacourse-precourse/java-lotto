package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class GameResultTest {
    private static final List<Integer> winningLotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    private static final Integer bonusNumber = 20;

    @DisplayName("로또가 당첨 번호와 몇 개 일치하는지 비교한다.")
    @Test
    void getMatchingCount() {
        List<Integer> oneMatching = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10, 11));
        List<Integer> twoMatching = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 10));
        List<Integer> threeMatching = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        List<Integer> fourMatching = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7, 8));
        List<Integer> fiveMatching = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
        List<Integer> sixMatching = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertAll(
                () -> assertThat(GameResult.getMatchingCount(oneMatching, winningLotto)).isEqualTo(1),
                () -> assertThat(GameResult.getMatchingCount(twoMatching, winningLotto)).isEqualTo(2),
                () -> assertThat(GameResult.getMatchingCount(threeMatching, winningLotto)).isEqualTo(3),
                () -> assertThat(GameResult.getMatchingCount(fourMatching, winningLotto)).isEqualTo(4),
                () -> assertThat(GameResult.getMatchingCount(fiveMatching, winningLotto)).isEqualTo(5),
                () -> assertThat(GameResult.getMatchingCount(sixMatching, winningLotto)).isEqualTo(6)
        );
    }

    @DisplayName("로또가 보너스 번호와 일치하는 번호가 있는지 비교한다.")
    @Test
    void isContainedBonusNumber() {
        List<Integer> matching = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10, 20));
        List<Integer> noMatching = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertAll(
                () -> assertThat(GameResult.isContained(matching, bonusNumber)).isEqualTo(true),
                () -> assertThat(GameResult.isContained(noMatching, bonusNumber)).isEqualTo(false)
        );
    }

    @DisplayName("당첨 기준에 따른 로또 등수를 구한다.")
    @Test
    void getGameRank() {
        List<Integer> threeMatching = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        List<Integer> fourMatching = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7, 8));
        List<Integer> fiveMatching = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
        List<Integer> fiveBonusMatching = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 20));
        List<Integer> sixMatching = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertAll(
                () -> assertThat(GameResult.getGameRank(threeMatching, winningLotto, bonusNumber)).isEqualTo(5),
                () -> assertThat(GameResult.getGameRank(fourMatching, winningLotto, bonusNumber)).isEqualTo(4),
                () -> assertThat(GameResult.getGameRank(fiveMatching, winningLotto, bonusNumber)).isEqualTo(3),
                () -> assertThat(GameResult.getGameRank(fiveBonusMatching, winningLotto, bonusNumber)).isEqualTo(2),
                () -> assertThat(GameResult.getGameRank(sixMatching, winningLotto, bonusNumber)).isEqualTo(1)
        );
    }
}