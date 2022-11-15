package lotto;

import lotto.domain.PrizeMoney;
import lotto.domain.Statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.Map.Entry;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsTest {
    private List<List<Integer>> lottos;
    private List<Integer> winningLottoNumbers;
    private int bonusNumber;
    private Statistics statistics;

    @BeforeEach
    public void 세팅() {
        statistics = new Statistics();
        lottos = List.of(List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 45),
                List.of(1, 2, 3, 4, 5, 7),
                List.of(1, 2, 3, 4, 7, 8),
                List.of(1, 2, 3, 9, 45),
                List.of(1, 2, 10, 11, 12, 45));
        winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        bonusNumber = 45;
    }

    @DisplayName("구매자의 6개의 로또가 각각 꽝~1등이 나오는지 테스트")
    @Test
    public void 구매자로또를_합격로또에_맞춰보기() {
        //given
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

    @DisplayName("구매자가 로또로 얻은 수익률을 계산한다.")
    @Test
    public void 수익률_계산() {
        //given
        statistics.countWinningLotto(lottos, winningLottoNumbers, bonusNumber);

        //when
        String rateReturn = statistics.computeRateReturn(2031555000);

        //then
        assertEquals("100.0", rateReturn);
    }

}