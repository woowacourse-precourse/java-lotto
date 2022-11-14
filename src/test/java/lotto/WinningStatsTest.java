package lotto;

import lotto.domain.WinningStats;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatsTest {
    @Test
    void matchNumbers_테스트1() {
        List<Integer> winningNumbers = List.of(1, 9, 16, 25, 33, 42);
        int bonusNumber = 45;
        List<Integer> lotto = List.of(1, 9, 17, 26, 34, 45);

        int result = 2;
        assertThat(result).isEqualTo(WinningStats.matchNumbers(winningNumbers, bonusNumber, lotto));
    }
    @Test
    void matchNumbers_테스트2() {
        List<Integer> winningNumbers = List.of(1, 9, 16, 25, 33, 42);
        int bonusNumber = 43;
        List<Integer> lotto = List.of(1, 9, 16, 25, 33, 44);

        int result = 5;
        assertThat(result).isEqualTo(WinningStats.matchNumbers(winningNumbers, bonusNumber, lotto));
    }
    @Test
    void matchNumbers_테스트3() {
        List<Integer> winningNumbers = List.of(1, 9, 16, 25, 33, 42);
        int bonusNumber = 45;
        List<Integer> lotto = List.of(1, 9, 16, 25, 33, 45);

        int result = 6;
        assertThat(result).isEqualTo(WinningStats.matchNumbers(winningNumbers, bonusNumber, lotto));
    }
    @Test
    void matchNumbers_테스트4() {
        List<Integer> winningNumbers = List.of(1, 9, 16, 25, 33, 42);
        int bonusNumber = 43;
        List<Integer> lotto = List.of(1, 9, 16, 25, 33, 42);

        int result = 7;
        assertThat(result).isEqualTo(WinningStats.matchNumbers(winningNumbers, bonusNumber, lotto));
    }
    @Test
    void WinningStats_테스트1() {
        List<Integer> winningNumbers = List.of(2, 8, 14, 30, 31, 37);
        int bonusNumber = 7;
        List<List<Integer>> purchasedLottos = new ArrayList<>();
        purchasedLottos.add(List.of(2, 8, 14, 30, 31, 37));
        purchasedLottos.add(List.of(2, 6, 14, 30, 31, 37));
        purchasedLottos.add(List.of(2, 7, 14, 30, 31, 37));

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>() {{
            put("FIFTH", 0);
            put("FOURTH", 0);
            put("THIRD", 1);
            put("SECOND", 1);
            put("FIRST", 1);
        }};

        assertThat(result).isEqualTo(new WinningStats(winningNumbers, bonusNumber, purchasedLottos).getStats());
    }
}
