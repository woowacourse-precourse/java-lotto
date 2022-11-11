package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {
    WinningNumbers winningNumbers = new WinningNumbers(
            List.of(1, 2, 3, 4, 5, 6)
            , 7
    );

    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,true", "5,true", "6,true", "7,false", "0,false"})
    void 어떤_숫자가_당첨번호에_포함되는지_확인한다(int number, boolean expected) {
        assertThat(winningNumbers.isWinningNumber(number)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"7,true", "2,false", "3,false", "11,false", "-3,false", "20,false"})
    void 어떤_숫자가_보너스번호인지_확인한다(int number, boolean expected) {
        assertThat(winningNumbers.isWinningNumber(number)).isEqualTo(expected);
    }
}