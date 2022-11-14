package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ComparisonTest {
    private Comparison comparison;
    private Lotto lotto;

    @BeforeEach
    public void setup() {
        comparison = new Comparison();
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨 번호와 일치하는 로또 번호의 개수를 구한다.")
    @Test
    public void countSameWinningNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(comparison.countWinningNumbers(lotto, winningNumbers))
                .isEqualTo(6);
    }

    @DisplayName("보너스 번호와 일치하는 로또 번호의 개수를 구한다.")
    @Test
    public void countSameBonusNumber() {
        int sameBonus = 3;
        int notSameBonus = 7;

        assertThat(comparison.countBonusNumber(lotto, sameBonus))
                .isEqualTo(1);
        assertThat(comparison.countBonusNumber(lotto, notSameBonus))
                .isEqualTo(0);
    }
}