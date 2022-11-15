package lotto;

import lotto.exception.WinNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinNumberTest {
    @DisplayName("당첨 번호가 숫자가 아닐 경우 오류가 발생한다.")
    @Test
    void createWinNumberByNotNumber() {
        assertThatThrownBy(() ->
                WinNumber.exceptionWinNumber("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45 범위를 벗어난 경우 오류가 발생한다.")
    @Test
    void createWinNumberByOverRange() {
        assertThatThrownBy(() ->
                WinNumber.exceptionWinNumber("1,2,3,4,66,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개가 아닐 경우 오류가 발생한다.")
    @Test
    void createWinNumberByOverLength() {
        assertThatThrownBy(() ->
                WinNumber.exceptionWinNumber("1,2,3,4,5,6,7,8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있을 때 오류가 발생한다.")
    @Test
    void createWinNumberByDuplicateWithWinNumber() {
        assertThatThrownBy(() ->
                WinNumber.exceptionDuplication(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}