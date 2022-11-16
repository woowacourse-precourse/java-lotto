package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    WinningNumbers winningNumbers = new WinningNumbers(
            List.of(1, 2, 3, 4, 5, 6)
            , 7
    );

    @Test
    void 보너스_번호가_당첨_번호와_중복이면_예외_던지기() {
        assertThatThrownBy(() -> {
            new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 5);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 임의의_숫자가_당첨번호인지_보너스인지_확인하는_기능() {
        CompareResult compareResult = new CompareResult(0, false);
        compareResult = winningNumbers.judgeWinningNumberOrBonus(1, compareResult);
        compareResult = winningNumbers.judgeWinningNumberOrBonus(7, compareResult);
        compareResult = winningNumbers.judgeWinningNumberOrBonus(0, compareResult);
        compareResult = winningNumbers.judgeWinningNumberOrBonus(9, compareResult);
        compareResult = winningNumbers.judgeWinningNumberOrBonus(3, compareResult);

        assertThat(compareResult).isEqualTo(new CompareResult(2, true));
    }
}