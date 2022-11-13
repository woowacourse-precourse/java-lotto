package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private final Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6)); //1등
    private final Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 9)); //2등
    private final Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 10)); //3등
    private final Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 10, 11)); //4등
    private final Lotto lotto5 = new Lotto(List.of(1, 2, 3, 10, 11, 12)); //5등
    private final Lotto lotto6 = new Lotto(List.of(10, 11, 12, 13, 14, 15)); //순위권 밖
    private final List<Lotto> lotto = List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
    private final List<Integer> winningNum = List.of(1, 2, 3, 4, 5, 6);
    private final int bonusNum = 9;
    private Calculator calc = new Calculator(winningNum, bonusNum, lotto);

    @DisplayName("주어진 로또에서 각 등수에 대한 count가 옳은지 확인한다.")
    @Test
    void getCountOfRank() {
        for (int i = 0; i < 5; i++) {
            assertThat(calc.getCountByRank(i+1)).isEqualTo(1);
        }
    }

    @DisplayName("주어진 로또에서 수익률이 옳은지 확인한다.")
    @Test
    void getYield() {
        assertThat(calc.getYield()).isEqualTo(338592.5);
    }


}