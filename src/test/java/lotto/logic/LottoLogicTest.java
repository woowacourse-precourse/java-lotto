package lotto.logic;

import lotto.domain.Lotto;
import lotto.domain.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoLogicTest {
    LottoLogic lottoLogic = new LottoLogic();

    List<List<Integer>> lottos = List.of(   // 일치하는 번호 개수 | 보너스 일치  |   상금
            List.of(8, 21, 23, 41, 42, 43), // 0                아니요         0
            List.of(1, 3, 5, 14, 22, 45),   // 3                아니요         5'000
            List.of(1, 3, 5, 2, 22, 45),    // 4                아니요         50'000
            List.of(1, 3, 5, 14, 4, 6),     // 5                아니요         1'500'000
            List.of(1, 3, 5, 7, 6, 2),      // 5                예            30'000'000
            List.of(1, 3, 5, 4, 6, 2),      // 6                아니요         2'000'000'000
            List.of(1, 33, 5, 4, 6, 7));    // 4                예            50'000

    List<Result> results = List.of(
            new Result(0, false),
            new Result(3, false),
            new Result(4, false),
            new Result(5, false),
            new Result(5, true),
            new Result(6, false),
            new Result(4, true));

    List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    Integer bonusNumber = 7;

    @Test
    void 여섯개의_임의의_중복없는_숫자조합으로_된_로또_생성() {
        for (int i = 0; i < 100; i++) {
            Lotto lotto = lottoLogic.makeLotto();
            Assertions.assertThat(lotto.getNumbers().size()).isEqualTo(6);
        }
    }

    @Test
    void 일치하는_번호_개수_세기() {
        for (int i = 0; i < results.size(); i++) {
            assertResult(results, i);
        }
    }

    @Test
    void 상금_테스트(){
        List<Integer> prizes = List.of(0, 5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000, 50_000);

        for (int i = 0; i < prizes.size(); i++) {
            Assertions.assertThat(lottoLogic.getPrize(results.get(i)))
                    .isEqualTo(prizes.get(i));
        }
    }

    @Test
    void 당첨_내역_테스트(){
        results.stream().forEach(result -> lottoLogic.addWinCount(result));

        List<Integer> countHistory = lottoLogic.getHistory();

        Assertions.assertThat(countHistory.get(1)).isEqualTo(1);    // 1등 1번
        Assertions.assertThat(countHistory.get(2)).isEqualTo(1);    // 2등 1번
        Assertions.assertThat(countHistory.get(3)).isEqualTo(1);    // 3등 1번
        Assertions.assertThat(countHistory.get(4)).isEqualTo(2);    // 4등 2번
        Assertions.assertThat(countHistory.get(5)).isEqualTo(1);    // 5등 1번
    }

    private void assertResult(List<Result> results, int i) {
        Result result = lottoLogic.compareNumbers(lottos.get(i), winningNumbers, bonusNumber);

        Assertions.assertThat(result.getMatchCount())
                .isEqualTo(results.get(i).getMatchCount());

        Assertions.assertThat(result.isMatchBonus())
                .isEqualTo(results.get(i).isMatchBonus());
    }
}