package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoMachine;
import lotto.domain.lotto_numbers.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("1,2,3등에 당첨된 복권이 한개씩 있을 경우 각 랭킹의 카운트가 1씩 증가한다.")
    @Test
    void winnings() {
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                new Lotto(List.of(30, 32, 33, 34, 35, 40))
        );

        WinningLotto winningLotto = lottoMachine
                .winningNumbers("1,2,3,4,5,6", "7");

        LottoResults lottoResults = winningLotto.lottoResults(purchasedLottos);
        Map<LottoRanking, Integer> actual = lottoResults.results();

        Map<LottoRanking, Integer> expected = Map.of(
                LottoRanking.FIFTH, 0,
                LottoRanking.FORTH, 0,
                LottoRanking.THIRD, 1,
                LottoRanking.SECOND, 1,
                LottoRanking.FIRST, 1
        );

        assertThat(actual).containsAllEntriesOf(expected);
    }
}