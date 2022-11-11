package lotto.service;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {
    @DisplayName("당첨 내역이 일치하는지 테스트")
    @Test
    void checkLottoResult() {
        List<Lotto> lotteries = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), new BonusNumber(45));
        Map<Prize, Integer> statistics = LottoResult.getStatistics(lotteries, winningLotto);
        assertThat(statistics.get(Prize.FIRST)).isEqualTo(2);
        assertThat(statistics.get(Prize.SECOND)).isEqualTo(1);
        assertThat(statistics.get(Prize.THIRD)).isEqualTo(1);
        assertThat(statistics.get(Prize.FOURTH)).isEqualTo(1);
        assertThat(statistics.get(Prize.FIFTH)).isEqualTo(1);
    }

    @DisplayName("총 상금이 당첨 내역 상금의 합계와 같은지 테스트")
    @Test
    void checkLottoResultPrizeMoney() {
        Map<Prize, Integer> statistics = new HashMap<>();
        statistics.put(Prize.FIRST, 1);
        statistics.put(Prize.SECOND, 1);
        statistics.put(Prize.THIRD, 1);
        statistics.put(Prize.FOURTH, 1);
        statistics.put(Prize.FIFTH, 1);
        statistics.put(Prize.NONE, 100);
        double prizeMoney = LottoResult.getPrizeMoney(statistics);
        assertThat(prizeMoney).isEqualTo(2031555000L);
    }

}