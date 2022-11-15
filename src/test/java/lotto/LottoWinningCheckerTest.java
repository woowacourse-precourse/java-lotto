package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningCheckerTest {
    private static final LottoMetadata lottoMetadata = new LottoMetadata.Builder().build();

    @DisplayName("같은 로또를 비교하면 1등 당첨이다.")
    @Test
    void prizeFirst() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoWinningChecker checker = new LottoWinningChecker(lottoMetadata);
        Integer bonus = 7;
        List<Lotto> lottos = List.of(lotto);

        Map<Prize, Integer> prizeIntegerMap =
                checker.countWinningLotto(lotto, lottos, bonus);

        assertThat(prizeIntegerMap.get(Prize.FIRST)).isEqualTo(1);
    }

    @DisplayName("1개의 요소가 다른 로또를 비교하는데 로또에 보너스 번호가 있다면 2등 당첨이다.")
    @Test
    void prizeSecond() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoWinningChecker checker = new LottoWinningChecker(lottoMetadata);
        Integer bonus = 7;
        List<Lotto> lottos = List.of(lotto);

        Map<Prize, Integer> prizeIntegerMap =
                checker.countWinningLotto(winningNumber, lottos, bonus);

        assertThat(prizeIntegerMap.get(Prize.SECOND)).isEqualTo(1);
    }

    @DisplayName("1개의 요소가 다른 로또를 비교하면 3등 당첨이다.")
    @Test
    void prizeThird() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        LottoWinningChecker checker = new LottoWinningChecker(lottoMetadata);
        Integer bonus = 7;
        List<Lotto> lottos = List.of(lotto);

        Map<Prize, Integer> prizeIntegerMap = checker.countWinningLotto(winningNumber, lottos, bonus);

        assertThat(prizeIntegerMap.get(Prize.THIRD)).isEqualTo(1);
    }

    @DisplayName("2개의 요소가 다른 로또를 비교하면 4등 당첨이다.")
    @Test
    void prizeFourth() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 5));
        LottoWinningChecker checker = new LottoWinningChecker(lottoMetadata);
        Integer bonus = 7;
        List<Lotto> lottos = List.of(lotto);

        Map<Prize, Integer> prizeIntegerMap = checker.countWinningLotto(winningNumber, lottos, bonus);

        assertThat(prizeIntegerMap.get(Prize.FOURTH)).isEqualTo(1);
    }

    @DisplayName("3개의 요소가 다른 로또를 비교하면 5등 당첨이다.")
    @Test
    void prizeFifth() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        LottoWinningChecker checker = new LottoWinningChecker(lottoMetadata);
        Integer bonus = 7;
        List<Lotto> lottos = List.of(lotto);

        Map<Prize, Integer> prizeIntegerMap = checker.countWinningLotto(winningNumber, lottos, bonus);

        assertThat(prizeIntegerMap.get(Prize.FIFTH)).isEqualTo(1);
    }
}