package lotto.model;

import static lotto.Application.ERROR_PREFIX;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {
    private static final String EMPTY_INPUT_ERROR_MESSAGE =
            ERROR_PREFIX + "번호를 입력하세요.";
    private static final String INPUT_FORMAT_ERROR_MESSAGE =
            ERROR_PREFIX + "당첨 숫자는 1~45 숫자를 '0,0,0,0,0,0' 형식으로 입력해주세요.";
    private static final String BONUS_FORMAT_ERROR_MESSAGE =
            ERROR_PREFIX + "보너스 숫자는 1~45 숫자를 당첨 숫자와 중복되지 않게 입력해주세요";

    static class ofNullAndEmptySourceProvider implements ArgumentsProvider {
        String validNumbers = "1,2,3,4,5,6";
        String validBonusNumber = "1";
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(null, validBonusNumber),
                    Arguments.of(validNumbers, null),
                    Arguments.of("", validBonusNumber),
                    Arguments.of(validNumbers,"")
            );
        }
    }

    @Nested
    @DisplayName("정적 팩토리 메서드 of 메서드는")
    class DescribeOf {
        @ParameterizedTest
        @ArgumentsSource(ofNullAndEmptySourceProvider.class)
        @DisplayName("null이나 빈문자열을 인자로 받으면 IllegalArgumentException을 반환한다.")
        void throwIllegalArgumentExceptionWhenNullAndEmptySource(String numbers, String bonusNumber) {
            Assertions.assertThatThrownBy(() -> WinningNumber.of(numbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(EMPTY_INPUT_ERROR_MESSAGE);
        }

        @ParameterizedTest
        @ValueSource(strings = {"what", "100,1,2,3,4,5", "1,2,3,4,5,46", "1, 2,3,4,5,6", "     "})
        @DisplayName("입력 조건에 맞지 않는 당첨번호를 인자로 받으면 IllegalArgumentException을 반환한다.")
        void throwIllegalArgumentExceptionWhenWrongWinningNumbers(String numbers) {
            String validBonusNumber = "45";

            Assertions.assertThatThrownBy(() -> WinningNumber.of(numbers, validBonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INPUT_FORMAT_ERROR_MESSAGE);
        }

        @ParameterizedTest
        @ValueSource(strings = {"what", "6", "46", "0", "-1", "100"})
        @DisplayName("입력 조건에 맞지 않는 보너스 번호를 인자로 받으면 IllegalArgumentException을 반환한다.")
        void throwIllegalArgumentExceptionWhenWrongBonusNumber(String bonusNumber) {
            String validNumbers = "1,2,3,4,5,6";

            Assertions.assertThatThrownBy(() -> WinningNumber.of(validNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(BONUS_FORMAT_ERROR_MESSAGE);
        }

        @Test
        @DisplayName("유효한 인자를 받으면 WinningNumber객체를 반환한다.")
        void willReturnWinningNumberWhenValidArgument() {
            String validNumbers = "1,2,3,4,5,6";
            String validBonusNumber = "7";

            WinningNumber actual = WinningNumber.of(validNumbers, validBonusNumber);

            Assertions.assertThat(actual.getClass()).isEqualTo(WinningNumber.class);
        }
    }

}