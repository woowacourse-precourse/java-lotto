package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumberValidatorTest {

    @ParameterizedTest
    @MethodSource("invalidWinningNumbers")
    @DisplayName("유효하지 않은 당첨 번호 입력 시 예외 발생")
    public void validateWinningNumbers(final String winningNumbers) {
        final var sut = new WinningNumberValidator();

        final Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> {
                sut.validate(winningNumbers);
            }
        );

        assertEquals("[ERROR] ,로 구분되는 6개의 1-45 사이의 숫자만 허용됩니다.", exception.getMessage());
    }

    static Stream<Arguments> invalidWinningNumbers() throws Throwable {
        return Stream.of(
            Arguments.of("1"),
            Arguments.of("1,2,3"),
            Arguments.of("1,2,3,4,5,5"),
            Arguments.of("-1,1,2,3,4,5"),
            Arguments.of("0,1,2,3,4,5"),
            Arguments.of("1,2,3,4,5,46"),
            Arguments.of("1,2,3,4,5,6,7")
        );
    }
}
