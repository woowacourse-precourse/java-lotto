package lotto;

import lotto.domain.Compare;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CompareTest {
    static Compare compare = new Compare();

    @DisplayName("로또 번호와 당첨 번호가 몇 개 일치하는지 테스트")
    @Test
    void lottoWinningMatchCount() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 8);
        List<Integer> winning = Arrays.asList(1, 2, 3, 4, 5, 7, 8); // 마지막 보너스 번호는 제외
        int result = compare.matchCount(lotto, winning);
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("로또 번호에 보너스 번호가 있는지 테스트")
    @Test
    void lottoWinningMatchBonus() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 8);
        List<Integer> winning = Arrays.asList(1, 2, 3, 4, 5, 7, 8);
        boolean result = compare.matchBonus(lotto, winning);
        assertThat(result).isEqualTo(true);
    }
}