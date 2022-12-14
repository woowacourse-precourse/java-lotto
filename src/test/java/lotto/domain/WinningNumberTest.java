package lotto.domain;

import java.util.List;
import java.util.stream.Stream;
import lotto.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumberTest {
    private static Stream<Arguments> generateLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 1),
                Arguments.of(List.of(5, 6, 7, 8, 9, 10), 10),
                Arguments.of(List.of(1, 45, 44, 43, 42, 2), 44),
                Arguments.of(List.of(6, 5, 4, 3, 2, 1), 6)
        );
    }

    @DisplayName("당첨 번호와 보너스 번호 비교에 대해 예외 발생 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoNumbers")
    void compareWinningNumberAndBonusNumber_exception(final List<Integer> numbers, final int bonusNumber) {
        // when
        WinningNumber winningNumber = new WinningNumber(numbers);

        // then
        Assertions.assertThatThrownBy(() -> winningNumber.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATED_LOTTO_NUMBER_ERROR);
    }
}