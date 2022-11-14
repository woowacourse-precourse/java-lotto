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
    void 어떤_숫자가_당첨번호_혹은_보너스인지_확인하는_기능() {
        CompareResult compareResult = new CompareResult(0, false);
        compareResult = winningNumbers.judgeWinningNumberOrBonus(1, compareResult);
        compareResult = winningNumbers.judgeWinningNumberOrBonus(7, compareResult);
        compareResult = winningNumbers.judgeWinningNumberOrBonus(0, compareResult);
        compareResult = winningNumbers.judgeWinningNumberOrBonus(9, compareResult);
        compareResult = winningNumbers.judgeWinningNumberOrBonus(3, compareResult);
        assertThat(compareResult).isEqualTo(new CompareResult(2, true));
    }

//    @ParameterizedTest
//    @CsvSource({"1,true", "2,true", "3,true", "4,true", "5,true", "6,true", "7,false", "0,false"})
//    void 어떤_숫자가_당첨번호에_포함되는지_확인한다(int number, boolean expected) {
//        assertThat(winningNumbers.isWinningNumber(number)).isEqualTo(expected);
//    }
//
//    @ParameterizedTest
//    @CsvSource({"7,true", "2,false", "3,false", "11,false", "-3,false", "20,false"})
//    void 어떤_숫자가_보너스번호인지_확인한다(int number, boolean expected) {
//        assertThat(winningNumbers.isBonusNumber(number)).isEqualTo(expected);
//    }
}