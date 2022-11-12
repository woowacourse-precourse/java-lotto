package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lottery.BonusNumber;
import lotto.domain.lottery.Lotto;
import lotto.domain.lottery.LottoGroup;
import lotto.domain.lottery.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    @DisplayName("로또 번호들 중 당첨의 수를 카운트합니다")
    void calculateMatchResults() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(4, 6, 8, 14, 25, 36)),
                new Lotto(List.of(4, 6, 10, 14, 25, 36)),
                new Lotto(List.of(3, 6, 14, 25, 27, 44)),
                new Lotto(List.of(4, 6, 14, 25, 36, 41))
        );
        LottoGroup lottoGroup = new LottoGroup(lottos);
        WinningLotto winningLotto = new WinningLotto("4,6,14,25,36,41");
        BonusNumber bonusNumber = new BonusNumber("8", winningLotto);
        Result result = new Result(lottoGroup, winningLotto, bonusNumber);

        List<Integer> answer = List.of(1, 0, 1, 1, 1);

        List<Integer> matchResults = result.calculateMatchResults(lottoGroup, winningLotto,
                bonusNumber);

        assertThat(matchResults)
                .isEqualTo(answer);
    }

}