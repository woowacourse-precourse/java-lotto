package lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("1등 당첨 결과 테스트")
    @Test
    void checkFirstWinningTest() {
        List<Integer> purchasedLotto = List.of(1, 2, 3, 4, 5, 6);
        int expect = 6;
        int result = WinningNumbersTest.winningNumbers.countWinning(purchasedLotto);
        assertThat(result).isEqualTo(expect);
    }
}
