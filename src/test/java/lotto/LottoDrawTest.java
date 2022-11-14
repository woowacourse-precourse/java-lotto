package lotto;

import lotto.store.LottoDraw;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoDrawTest {

    LottoDraw lottoDraw = LottoDraw.getInstance();

    @DisplayName("쉼표로 구분한 요소가 6개가 아닌 경우 예외 발생")
    @Test
    void splitComma() {
        String input = "1,2,3,4,5";
        assertThatThrownBy(() -> lottoDraw.pickWinNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표로 구분한 요소가 숫자가 아닌 경우 예외 발생")
    @Test
    void splitCommaException() {
        String input = "1,2,3,4,5,j";
        assertThatThrownBy(() -> lottoDraw.pickWinNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개의 숫자에 중복이 있는 경우 예외 발생")
    @Test
    void duplicationInNumbers() {
        String input = "1,2,3,4,5,5";
        assertThatThrownBy(() -> lottoDraw.pickWinNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~45 까지의 범위를 벗어난 숫자가 있는 경우 예외 발생")
    @Test
    void validateRange() {
        String input = "1, 2, 3, 4, 5, 46";
        assertThatThrownBy(() -> lottoDraw.pickWinNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표로 구분한 중복이 없는 6개의 숫자가 맞는 경우 리스트 반환")
    @Test
    void correctDataResult() {
        String input = "1,2,3,4,5,6";
        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);
        assertThat(lottoDraw.pickWinNumbers(input)).isEqualTo(result);
    }

    @DisplayName("보너스 번호에 구분자가 있는 경우 예외가 발생한다.")
    @Test
    void validateSeparator() {
        String input = "1,2";
        assertThatThrownBy(() -> lottoDraw.pickBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void validateNumericException() {
        String input = "w";
        assertThatThrownBy(() -> lottoDraw.pickBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위 외인 경우 예외가 발생한다.")
    @Test
    void validateRangeException() {
        String input = "0";
        assertThatThrownBy(() -> lottoDraw.pickBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
