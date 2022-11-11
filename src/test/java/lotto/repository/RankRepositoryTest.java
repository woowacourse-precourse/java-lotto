package lotto.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankRepositoryTest {

    @Test
    @DisplayName("보너스 숫자를 제외하고 숫자 6개가 일치한다면 1등이다.")
    public void getRankFirstPrize() {
        // given
        Lotto playerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        // when
        Rank rank = RankRepository.getRank(playerLotto, winningLotto);
        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("보너스 숫자와 숫자 5개가 일치한다면 2등이다.")
    public void getRankSecondPrize() {
        // given
        Lotto playerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 45)), 6);
        // when
        Rank rank = RankRepository.getRank(playerLotto, winningLotto);
        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("보너스 숫자는 일치하지 않고 숫자 5개가 일치한다면 3등이다.")
    public void getRankThirdPrize() {
        // given
        Lotto playerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 45)), 44);
        // when
        Rank rank = RankRepository.getRank(playerLotto, winningLotto);
        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("보너스 숫자를 제외하고 숫자 4개가 일치한다면 4등이다.")
    public void getRankFourthPrize() {
        // given
        Lotto playerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 45, 44)), 43);
        // when
        Rank rank = RankRepository.getRank(playerLotto, winningLotto);
        // then
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("보너스 숫자를 제외하고 숫자 3개가 일치한다면 5등이다.")
    public void getRankFifthPrize() {
        // given
        Lotto playerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 45, 44, 43)), 42);
        // when
        Rank rank = RankRepository.getRank(playerLotto, winningLotto);
        // then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

}