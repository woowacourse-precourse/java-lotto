package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.utils.ErrorMessages.WINNING_NUMBERS_NOT_INTEGER;
import static lotto.utils.ErrorMessages.WINNING_NUMBERS_SEPARATOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @DisplayName("로또 당첨 번호가 쉼표로 구분되어 있지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2:3,4,5", "1,2,3 4,5"})
    void createWinningNumbersBySeparator(String numbers) {
        assertThatThrownBy(() -> new WinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBERS_SEPARATOR);
    }

    @DisplayName("로또 당첨 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,a,4,5", "!1,2,3,4,5,6", "a,b,c,d,e,f"})
    void createWinningNumbersByNotInteger(String numbers) {
        assertThatThrownBy(() -> new WinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBERS_NOT_INTEGER);
    }

    @DisplayName("로또 당첨 번호를 리스트로 변환한다.")
    @ParameterizedTest
    @MethodSource("generateData")
    void WinningNumbersToList(String input, List<Integer> expectedNumbers) {
        WinningLotto winningNumbers = new WinningLotto(input);
        Lotto numbers = winningNumbers.getWinningNumbers();
        assertThat(numbers.getNumbers())
                .isEqualTo(expectedNumbers);
    }

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("4,45,1,29,23,18", List.of(4, 45, 1, 29, 23, 18))
        );
    }
}
