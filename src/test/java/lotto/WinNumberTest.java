package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WinNumberTest {

    @DisplayName("당첨 숫자 유효성 검사 확인")
    @ParameterizedTest
    @MethodSource("provideInputWinNumbers")
    void inputWinNumbersTest(String input) {
        WinNumber winNumber = new WinNumber();
        Assertions.assertThatThrownBy(()->winNumber.inputWinNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionHandler.WRONG_WIN_NUMBERS);
    }

    private static Stream<Arguments> provideInputWinNumbers() {
        return Stream.of(
                Arguments.of("1.2.3.4.5.6"),
                Arguments.of("123456"),
                Arguments.of("1,2,3,4"),
                Arguments.of("1,2,3,4,5,6,7")
        );
    }

    @DisplayName("보너스 숫자 유효성 검사 확인")
    @ParameterizedTest
    @MethodSource("provideInputBonusNumber")
    void validateBonusNumberTest(String input) {
        WinNumber winNumber = new WinNumber();
        for (int i = 0; i < Lotto.WIN_NUMBER_SIZE; i++) {
            winNumber.getWinNumbers().add(i + 1);
        }
        Assertions.assertThatThrownBy(()->winNumber.inputBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionHandler.WRONG_BONUS_NUMBERS);
    }

    private static Stream<Arguments> provideInputBonusNumber() {
        return Stream.of(
                Arguments.of("abc"),
                Arguments.of("0"),
                Arguments.of("46"),
                Arguments.of("3")
        );
    }


}