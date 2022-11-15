package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.service.ResultService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {
    @DisplayName("로또 번호 6개가 일치하면 1등에 해당한다.")
    @Test
    void getFirstRank() {
        User user = new User(1000, List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 10);
        Result result = ResultService.addRankResult(user, winningLotto);
        assertThat(result.getResults().get(Rank.FIRST))
                .isEqualTo(1);
    }

    @DisplayName("로또 번호 5개와 보너스 번호가 일치하면 2등에 해당한다.")
    @Test
    void getSecondRank() {
        User user = new User(1000, List.of(new Lotto(List.of(1, 2, 3, 4, 5, 10))));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 10);
        Result result = ResultService.addRankResult(user, winningLotto);
        assertThat(result.getResults().get(Rank.SECOND))
                .isEqualTo(1);
    }

    @DisplayName("로또 번호 5개가 일치하면 3등에 해당한다.")
    @Test
    void getThirdRank() {
        User user = new User(1000, List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7))));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 10);
        Result result = ResultService.addRankResult(user, winningLotto);
        assertThat(result.getResults().get(Rank.THIRD))
                .isEqualTo(1);
    }

    @DisplayName("로또 번호 4개가 일치하면 4등에 해당한다.")
    @Test
    void getFourthRank() {
        User user = new User(1000, List.of(new Lotto(List.of(1, 2, 3, 4, 7, 8))));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 10);
        Result result = ResultService.addRankResult(user, winningLotto);
        assertThat(result.getResults().get(Rank.FOURTH))
                .isEqualTo(1);
    }

    @DisplayName("로또 번호 3개가 일치하면 5등에 해당한다.")
    @Test
    void getFifthRank() {
        User user = new User(1000, List.of(new Lotto(List.of(1, 2, 3, 7, 8, 9))));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 10);
        Result result = ResultService.addRankResult(user, winningLotto);
        assertThat(result.getResults().get(Rank.FIFTH))
                .isEqualTo(1);
    }
}
