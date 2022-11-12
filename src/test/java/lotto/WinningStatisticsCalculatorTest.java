package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticsCalculatorTest {
    @DisplayName("로또 등수 개수 세기")
    @Test
    void createDifferentPurchaseLottos() {
        List<Lotto> lottos = new ArrayList<>(){{
            add(new Lotto("1,2,3,4,5,6"));
            add(new Lotto("1,2,3,4,5,7"));
            add(new Lotto("1,2,3,4,5,8"));
            add(new Lotto("1,2,3,4,8,9"));
            add(new Lotto("1,2,3,8,9,10"));
        }};
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;
        HashMap<WinningHistory, Integer> result = new HashMap<>() {{
            put(WinningHistory.FIRST_PRIZE, 1);
            put(WinningHistory.SECOND_PRIZE, 1);
            put(WinningHistory.THIRD_PRIZE, 1);
            put(WinningHistory.FOURTH_PRIZE, 1);
            put(WinningHistory.FIFTH_PRIZE, 1);
            put(WinningHistory.BLANK, 0);
        }};

        WinningStatisticsCalculator winningStatisticsCalculator = new WinningStatisticsCalculator(lottos, lotto, bonus);
        assertThat(winningStatisticsCalculator.getWinningHistory()).isEqualTo(result);
    }
}
