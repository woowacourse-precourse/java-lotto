package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {
    @DisplayName("등수가 제대로 나왔는지 확인")
    @Test
    void TestRankIsCorrect() {
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 42)));
        List<Lotto> lottoBundle = List.of(lotto);
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        WinningNumber winningNumber = new WinningNumber(winningNumbers);
        winningNumber.setBonusNumber(42);
        LottoStatistics statistics = new LottoStatistics(lottoBundle, winningNumber);
        Map<Rank, Integer> result = statistics.getResults();
        assertThat(result.getOrDefault(Rank.SECOND, 0)).isEqualTo(1);
    }
}