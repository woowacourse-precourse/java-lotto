package lotto.domain;

import static lotto.domain.Calculator.hasNotBonus;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    WinningNumbers sampleWinningNumbers1 = new WinningNumbers(new Lotto(List.of(7, 8, 9, 10, 11, 12)), 6);
    WinningNumbers sampleWinningNubmers2 = new WinningNumbers(new Lotto(List.of(8, 9, 10, 11, 12, 13)), 7);

    @DisplayName("로또 번호 중 보너스 번호가 존재하지 않는지 확인한다")
    @Test
    void checkBonusDontExists() {
        assertThat(hasNotBonus(sampleWinningNubmers2, lotto)).isEqualTo(true);
    }

    @DisplayName("로또 번호 중 보너스 번호가 존재하는지 확인한다")
    @Test
    void checkBonusExists() {
        assertThat(hasNotBonus(sampleWinningNumbers1, lotto)).isEqualTo(false);
    }



}