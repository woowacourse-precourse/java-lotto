package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    private final WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Test
    void validate_notInCorrectRange_fail() {
        assertThatThrownBy(() -> new BonusNumber(67, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45사이의 숫자여야 합니다.");
    }

    @Test
    void validate_containsWinningNumbers_fail() {
        assertThatThrownBy(() -> new BonusNumber(4, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

    @Test
    void getBonusNumber_validInput_success() {
        BonusNumber bn = new BonusNumber(40, winningNumbers);
        assertThat(bn.getBonusNumber()).isEqualTo(40);
    }
}