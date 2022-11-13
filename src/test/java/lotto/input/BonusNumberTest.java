package lotto.input;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    static final List<Integer> WINNING_NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    void validate_notNumber_Fail() {
        assertThatThrownBy(() -> new BonusNumber("a", WINNING_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 숫자여야 합니다.");
    }

    @Test
    void validate_notInCorrectRange_Fail() {
        assertThatThrownBy(() -> new BonusNumber("67", WINNING_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void validate_containsWinningNumbers_Fail() {
        assertThatThrownBy(() -> new BonusNumber("4", WINNING_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

    @Test
    void getBonusNumber_validInput_Success() {
        BonusNumber bn = new BonusNumber("40", WINNING_NUMBERS);
        assertThat(bn.getBonusNumber()).isEqualTo(40);
    }
}