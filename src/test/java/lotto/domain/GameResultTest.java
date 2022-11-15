package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class GameResultTest {
    static final List<Integer> winningLotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

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
}