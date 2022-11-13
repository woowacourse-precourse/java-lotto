package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.utils.ErrorMessages.WINNING_NUMBERS_SEPARATOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningNumbersTest {
    @DisplayName("로또 당첨 번호가 쉼표로 구분되어 있지 않으면 예외가 발생한다.")
    @Test
    void createWinningNumbersBySeparator() {
        assertThatThrownBy(() -> new LottoWinningNumbers("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBERS_SEPARATOR);
    }

    @DisplayName("로또 당첨 번호를 리스트로 변환한다.")
    @ParameterizedTest
    @MethodSource("generateData")
    void WinningNumbersToList(String input, List<Integer> expectedNumbers) {
        LottoWinningNumbers winningNumbers = new LottoWinningNumbers(input);
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
