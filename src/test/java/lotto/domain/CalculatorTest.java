package lotto.domain;

import static lotto.domain.Calculator.hasNotBonus;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    Lotto sampleLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    Lotto sampleLotto2 = new Lotto(List.of(45, 44, 43, 42, 41, 40));
    Lotto sampleLotto3 = new Lotto(List.of(5, 6, 7, 8, 9, 10));
    Lotto sampleLotto4 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
    WinningNumbers sampleWinningNumbers1 = new WinningNumbers(new Lotto(List.of(7, 8, 9, 10, 11, 12)), 6);
    WinningNumbers sampleWinningNubmers2 = new WinningNumbers(new Lotto(List.of(8, 9, 10, 11, 12, 13)), 7);
    WinningNumbers sampleWinningNubmers3 = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
    Calculator getRankCount1 = new Calculator(sampleWinningNumbers1, List.of(sampleLotto1, sampleLotto2));
    Calculator getRankCount2 = new Calculator(sampleWinningNubmers3,
            List.of(sampleLotto1, sampleLotto2, sampleLotto3, sampleLotto4));

    @DisplayName("로또 번호 중 보너스 번호가 존재하지 않는지 확인한다")
    @Test
    void checkBonusDontExists() {
        assertThat(hasNotBonus(sampleWinningNubmers2, sampleLotto1)).isEqualTo(true);
    }

    @DisplayName("로또 번호 중 보너스 번호가 존재하는지 확인한다")
    @Test
    void checkBonusExists() {
        assertThat(hasNotBonus(sampleWinningNumbers1, sampleLotto1)).isEqualTo(false);
    }

    @DisplayName("총 수익률이 잘 계산되는지 확인한다")
    @Test
    void calculateTotalPrice() {
        assertThat(getRankCount1.getTotalPrice()).isEqualTo(0);
        assertThat(getRankCount2.getTotalPrice()).isEqualTo(2_030_000_000);
    }

}