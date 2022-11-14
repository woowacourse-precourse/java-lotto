package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import constants.ExceptionMessage;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningBallsTest {

    @DisplayName("당첨번호가 6자리가 아니면 예외 발생")
    @Test
    void create_GeneralWinNumberNot6Digit() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new WinningBalls(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.MUST_SIX_DIGIT);
    }

    @DisplayName("당첨번호가 6자리면 정상 진행")
    @Test
    void createGeneralWinNumber6Digit() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatCode(() -> new WinningBalls(numbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("범위에 벗어나는 숫자가 있을 경우 예외 발생")
    @Test
    void createGeneralWinNumberNotWithInRange() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> new WinningBalls(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.WITHIN_RANGE);
    }

    @DisplayName("모든 숫자가 범위를 충족할 경우 정상 진행")
    @Test
    void createGeneralWinNumberWithIn_Range() {
        List<Integer> numbers = Arrays.asList(1, 7, 12, 23, 38, 45);

        assertThatCode(() -> new WinningBalls(numbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("중복되는 숫자가 있을 경우")
    @Test
    void createGeneralWinNumberDuplicate() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 5);

        assertThatThrownBy(() -> new WinningBalls(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.DUPLICATE_NUMBERS);
    }

    @DisplayName("중복되는 숫자가 없을 경우")
    @Test
    void createGeneralWinNumberNotDuplicate() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatCode(() -> new WinningBalls(numbers))
                .doesNotThrowAnyException();
    }

}