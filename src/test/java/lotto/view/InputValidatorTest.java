package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    private static Stream<Arguments> oneInteger() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("100", 100),
                Arguments.of("234", 234)
        );
    }

    private static Stream<Arguments> Integers() {
        return Stream.of(
                Arguments.of("1,2,3,4", List.of(1, 2, 3, 4)),
                Arguments.of("3,4,5,6", List.of(3, 4, 5, 6)),
                Arguments.of("0,0,0,0", List.of(0, 0, 0, 0))
        );
    }


    @DisplayName("int 숫자로 변환하는 과정을 담당함")
    @ParameterizedTest
    @MethodSource("oneInteger")
    void toInt_메서드_정상작동(String input, int result) {
        assertThat(InputValidator.toInt(input)).isEqualTo(result);
    }

    @DisplayName("int 숫자로 변환할 수 없는 경우 IEA 예외")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"234 ", "a234", "22000000000"})
    void toInt_메서드_변환_불가_예외(String input) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.toInt(input));
    }

    @DisplayName("숫자로 변환하는 과정을 담당함")
    @ParameterizedTest
    @MethodSource("Integers")
    void splitToIntegers_메서드_정상작동(String input, List<Integer> result) {
        assertThat(InputValidator.splitToIntegers(input)).isEqualTo(result);
    }

    @DisplayName("숫자들로 변환할 수 없는 경우 IEA 예외")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"234 ", "a234", "1,2,,3", "1,2,3,a"})
    void splitToIntegers_메서드_변환_불가_예외(String input) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.splitToIntegers(input));
    }

    @DisplayName("long 숫자로 변환하는 과정을 담당함")
    @Test
    void toLong_메서드_정상작동() {
        assertThat(InputValidator.toLong("22000000000")).isEqualTo(22000000000L);
    }

    @DisplayName("long 숫자로 변환할 수 없는 경우 IEA 예외")
    @Test
    void toLong_메서드_변환_불가_예외() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.toLong("2200000000000000000000000"));
    }
}
