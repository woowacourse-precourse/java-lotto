package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {
    WinningNumbers winningNumbers = new WinningNumbers(
            List.of(1, 2, 3, 4, 5, 6)
            , 7
    );

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