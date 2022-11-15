package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.model.InputException;
import org.junit.jupiter.api.Test;

class InputExceptionTest {
    @Test
    void isValidNumber() {
        final String input = "50q0";
        assertThatThrownBy(() -> InputException.isValidNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidDivide() {
        final String input = "2500";
        assertThatThrownBy(() -> InputException.isValidDivide(Integer.parseInt(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 단위로 입력해 주세요.");
    }

    @Test
    void isValidWinningNumberLength() {
        final String input = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> InputException.isValidWinningNumberLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6자리 숫자와 쉼표로 입력해 주세요.");
    }

    @Test
    void isValidWinningNumber() {
        final String input = "1,2,3,4,q,6,7";
        assertThatThrownBy(() -> InputException.isValidWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해 주세요.");
    }

    @Test
    void isValidWinningNumberOverlap() {
        final String input = "1,2,3,2,5,6";
        assertThatThrownBy(() -> InputException.isValidWinningNumberOverlap(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복되지 않는 숫자를 입력하세요.");
    }

    @Test
    void isValidWinningNumberRange() {
        final int[] input = {2, 3, 67, 122, 400, 159};
        assertThatThrownBy(() -> InputException.isValidWinningNumberRange(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 숫자를 입력하세요.");
    }

    @Test
    void isValidWBonusNumber() {
        final String input = "qqwe";
        assertThatThrownBy(() -> InputException.isValidWBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해 주세요.");
    }

    @Test
    void isValidBonusNumberOverlap() {
        final int bonusNumber = 6;
        List<Integer> input = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> InputException.isValidBonusNumberOverlap(input, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호와 중복되지 않는 숫자를 입력하세요.");
    }

    @Test
    void isValidWBonusRange() {
        final String input = "1234";
        assertThatThrownBy(() -> InputException.isValidWinningNumberOverlap(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1~45 숫자를 입력하세요.");
    }
}