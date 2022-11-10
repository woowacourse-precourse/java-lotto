package lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.WinningNumbers;

public class WinningNumbersTest {

    @DisplayName("중복되는 값 예외 처리")
    @Test
    void checkDuplicatedException() {
        List<Integer> inputs = List.of(1, 1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new WinningNumbers(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트 length 적을 때 예외 처리")
    @Test
    void checkLessLengthException() {
        List<Integer> inputs = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new WinningNumbers(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("리스트 length 클 때 예외 처리")
    @Test
    void checkMoreLengthException() {
        List<Integer> inputs = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> new WinningNumbers(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어나는 수를 포함하고 있는 경우 예외 처리")
    @Test
    void checkRangeException() {
        List<Integer> inputs = List.of(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> new WinningNumbers(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
