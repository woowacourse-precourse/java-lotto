package lotto;

import lotto.domain.PrizeMoney;
import lotto.domain.Statistics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.Map.Entry;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsTest {

    @DisplayName("구매자의 6개의 로또가 각각 꽝~1등이 나오는지 테스트")
    @Test
    public void 구매자로또를_합격로또에_맞춰보기() {
        //given
        List<List<Integer>> lottos = List.of(List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 45),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 7, 8),
                List.of(1, 2, 3, 9, 45),
                List.of(1, 2, 10, 11, 12, 45));
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;
        Statistics statistics = new Statistics();
        statistics.countWinningLotto(lottos, winningLottoNumbers, bonusNumber);

        //when
        Map<PrizeMoney, Integer> winningHistory = statistics.getWinningHistory();
        Set<PrizeMoney> actual = new HashSet<>();
        for (Entry<PrizeMoney, Integer> entry : winningHistory.entrySet()) {
            PrizeMoney prizeMoney = entry.getKey();
            int countOfWinning = entry.getValue();
            if (countOfWinning == 1) {
                actual.add(prizeMoney);
            }
        }

        //then
        assertEquals(5, actual.size());
    }
}