package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class WinningNumbersExceptionTest {

    @Test
    void 당첨번호_숫자_6개_확인() {

        assertThatThrownBy(() -> WinningNumbersException.checkRightWinningNumbersSize(List.of("23")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningNumbersException.checkRightWinningNumbersSize(List.of("1", "3")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningNumbersException.checkRightWinningNumbersSize(List.of("1", "45", "22")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->
                WinningNumbersException.checkRightWinningNumbersSize(List.of("1", "45", "22", "1", "21", "38", "34")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨숫자_중복된_숫자_확인() {
        assertThatThrownBy(
                () -> WinningNumbersException.checkUniqueWinningNumbers(Set.of("23", "23", "21", "14", "6", "34")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> WinningNumbersException.checkUniqueWinningNumbers(Set.of("11", "34", "21", "11", "9", "37")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> WinningNumbersException.checkUniqueWinningNumbers(Set.of("1", "39", "8", "28", "8", "41")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨숫자_1개씩_확인() {

        assertThatThrownBy(
                () -> WinningNumbersException.checkEachWinningNumber(List.of("1", "56", "34", "21", "34", "12")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> WinningNumbersException.checkEachWinningNumber(List.of("1", "45", " 34", "27", "34", "17")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> WinningNumbersException.checkEachWinningNumber(List.of("1", "45", "34", "21", "test", "13")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> WinningNumbersException.checkEachWinningNumber(List.of("1", "45", " ", "21", "31", "13")))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> WinningNumbersException.checkEachWinningNumber(List.of("1", "45", "19", "21", "31", "")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_숫자인지_확인() {

        assertThatThrownBy(() -> WinningNumbersException.checkWinningNumberDigit("test"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningNumbersException.checkWinningNumberDigit("1abc"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningNumbersException.checkWinningNumberDigit("한글"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningNumbersException.checkWinningNumberDigit("test1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_1과_45_사이인지_확인() {

        assertThatThrownBy(() -> WinningNumbersException.checkWinningNumberRange(-1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningNumbersException.checkWinningNumberRange(46))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningNumbersException.checkWinningNumberRange(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> WinningNumbersException.checkWinningNumberRange(100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
