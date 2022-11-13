package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.lottoenum.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeCalculatorTest {

    @DisplayName("로또 당첨 결과를 계산한다")
    @Test
    void calculateLottoWinResultTest() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 10, 4, 5, 6)), //3개 일치
                new Lotto(List.of(1, 2, 10, 20, 30, 45)), // 5개 + 보너스 일치
                new Lotto(List.of(1, 2, 10, 40, 20, 23)), //5개만 일치
                new Lotto(List.of(10, 20, 30, 45, 6, 7)), //3개 + 보너스 일치 -> 3개 일치로 연산
                new Lotto(List.of(1, 4, 5, 6, 7, 8)) //1개 일치 -> 포함 X
        );
        Lotto winningLottoNumbers = new Lotto(List.of(10, 20, 30, 40, 1, 2));
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, 45);
        Map<Prize, Integer> result = new EnumMap<>(Map.of(
                Prize.FIFTH, 2,
                Prize.THIRD, 1,
                Prize.SECOND, 1
        ));

        Map<Prize, Integer> prizeCountMap = PrizeCalculator.calculatePrize(lottos, winningLotto);

        assertAll(
                () -> assertThat(prizeCountMap).containsAllEntriesOf(result),
                () -> assertThat(prizeCountMap).doesNotContainKeys(Prize.FIRST, Prize.FOURTH)
        );
    }

}
