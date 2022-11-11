package lotto;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.WinningNumbers;

public class WinningNumbersTest {
    private static WinningNumbers winningNumbers;

    @BeforeAll
    static void generateWinningNumber() {
        winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    }

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

    @DisplayName("당첨 번호 카운트 테스트")
    @ParameterizedTest(name = "{displayName} {index}등")
    @MethodSource("generateDataForWinningTest")
    void checkCountWinningTest(List<Integer> purchasedLotto, int expect) {
        int result = WinningNumbersTest.winningNumbers.countWinning(purchasedLotto);
        assertThat(result).isEqualTo(expect);
    }

    static Stream<Arguments> generateDataForWinningTest() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), 4),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), 3)
                );
    }
}
