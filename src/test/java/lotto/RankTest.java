package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    private WinningLotto winningLotto;

    @BeforeEach
    void setWinningLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        int bonusNumber = 7;
        this.winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    @DisplayName("6개의 번호가 일치하면 1등이다.")
    @Test
    void createRankTypeOfFirst() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        Rank rank = Rank.getRank(lotto, winningLotto);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개의 번호와 보너스 번호가 일치하면 2등이다.")
    @Test
    void createRankTypeOfSecond() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        Lotto lotto = new Lotto(numbers);
        Rank rank = Rank.getRank(lotto, winningLotto);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개의 번호가 일치하면 3등이다.")
    @Test
    void createRankTypeOfThird() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 10);
        Lotto lotto = new Lotto(numbers);
        Rank rank = Rank.getRank(lotto, winningLotto);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4개의 번호가 일치하면 4등이다.")
    @Test
    void createRankTypeOfForth() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 7, 10);
        Lotto lotto = new Lotto(numbers);
        Rank rank = Rank.getRank(lotto, winningLotto);

        assertThat(rank).isEqualTo(Rank.FORTH);
    }

    @DisplayName("3개의 번호가 일치하면 5등이다.")
    @Test
    void createRankTypeOfFifth() {
        List<Integer> numbers = List.of(1, 2, 3, 7, 8, 10);
        Lotto lotto = new Lotto(numbers);
        Rank rank = Rank.getRank(lotto, winningLotto);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("3개 미만의 번호가 일치하면 꽝이다.")
    @Test
    void createRankTypeOfMiss() {
        List<Integer> numbers = List.of(10, 20, 30, 40, 41, 42);
        Lotto lotto = new Lotto(numbers);
        Rank rank = Rank.getRank(lotto, winningLotto);

        assertThat(rank).isEqualTo(Rank.MISS);
    }
}
