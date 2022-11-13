package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto_numbers.BonusNumber;
import lotto.domain.lotto_numbers.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("1,2,3등에 당첨된 복권이 한개씩 있을 경우 각 랭킹의 카운트가 1씩 증가한다.")
    @Test
    void winnings() {
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                new Lotto(List.of(30, 32, 33, 34, 35, 40))
        );

        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new BonusNumber(7)
        );

        LottoResults lottoResults = winningLotto.lotteryResults(purchasedLottos);
        Map<Ranking, Integer> actual = lottoResults.results();

        Map<Ranking, Integer> expected = Map.of(
                Ranking.FIFTH, 0,
                Ranking.FORTH, 0,
                Ranking.THIRD, 1,
                Ranking.SECOND, 1,
                Ranking.FIRST, 1
        );

        assertThat(actual).containsAllEntriesOf(expected);
    }
}