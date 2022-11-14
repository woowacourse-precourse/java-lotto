package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    private static Result result;

    @BeforeEach
    void beforeEach() {
        result = new Result();
    }

    @Test
    @DisplayName("당첨 번호와 로또 번호가 모두 일치할 경우 1등")
    void testName() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        result.matchLotto(winningNumber, lottos, bonusNumber);
        Map<Rank, Integer> rankInfo = result.getRankInfo();
        assertThat(rankInfo).contains(entry(Rank.FIRST, 1), entry(Rank.SECOND, 0), entry(Rank.THIRD, 0),
                entry(Rank.FOURTH, 0), entry(Rank.FIFTH, 0));
    }

    @Test
    @DisplayName("당첨 번호와 로또 번호가 5개 그리고 보너스 번호가 일치할 경우 2등")
    void testName2() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        result.matchLotto(winningNumber, lottos, bonusNumber);
        Map<Rank, Integer> rankInfo = result.getRankInfo();

        assertThat(rankInfo).contains(entry(Rank.FIRST, 0), entry(Rank.SECOND, 1), entry(Rank.THIRD, 0),
                entry(Rank.FOURTH, 0), entry(Rank.FIFTH, 0));
    }

    @Test
    @DisplayName("당첨 번호와 로또 번호가 5개가 일치할 경우 3등")
    void testName3() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)));

        result.matchLotto(winningNumber, lottos, bonusNumber);
        Map<Rank, Integer> rankInfo = result.getRankInfo();

        assertThat(rankInfo).contains(entry(Rank.FIRST, 0), entry(Rank.SECOND, 0), entry(Rank.THIRD, 1),
                entry(Rank.FOURTH, 0), entry(Rank.FIFTH, 0));
    }

    @Test
    @DisplayName("당첨 번호와 로또 번호가 4개가 일치할 경우 4등")
    void testName4() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 9, 10)));

        result.matchLotto(winningNumber, lottos, bonusNumber);
        Map<Rank, Integer> rankInfo = result.getRankInfo();

        assertThat(rankInfo).contains(entry(Rank.FIRST, 0), entry(Rank.SECOND, 0), entry(Rank.THIRD, 0),
                entry(Rank.FOURTH, 1), entry(Rank.FIFTH, 0));
    }

    @Test
    @DisplayName("당첨 번호와 로또 번호가 3개가 일치할 경우 5등")
    void testName5() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 11, 15, 16)));

        result.matchLotto(winningNumber, lottos, bonusNumber);
        Map<Rank, Integer> rankInfo = result.getRankInfo();

        assertThat(rankInfo).contains(entry(Rank.FIRST, 0), entry(Rank.SECOND, 0), entry(Rank.THIRD, 0),
                entry(Rank.FOURTH, 0), entry(Rank.FIFTH, 1));
    }

    @Test
    @DisplayName("로또를 8000원을 구매해 5등 1개가 당첨됐을 경우 수익률은 62.5%이다.")
    void getWinningAmount() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 11, 15, 16)));

        result.matchLotto(winningNumber, lottos, bonusNumber);
        result.initWinningAmount(8000);

        assertThat(String.format("%.1f", result.getWinningAmount())).isEqualTo("62.5");
    }
}