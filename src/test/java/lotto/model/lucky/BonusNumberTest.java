package lotto.model.lucky;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BonusNumberTest {

    @Nested
    @DisplayName("BonusNumber Class")
    class BonusNumberKoTest {

        @Nested
        @TestInstance(Lifecycle.PER_CLASS)
        @DisplayName("validation for sign")
        class DescribeValidateSign {

            @DisplayName("wrong input of")
            @ParameterizedTest(name = "{1}")
            @MethodSource("invalidParameters")
            void validateNumbers(String input, String message) {
                Assertions.assertThatThrownBy(() -> {

                    BonusNumber bonusNumber = new BonusNumber(input, null);

                }).hasMessageContaining("[ERROR] The bonus number must be positive.");

            }

            Stream<Arguments> invalidParameters() throws Throwable {
                return Stream.of(
                    Arguments.of("-1", "under min boundary1"),
                    Arguments.of("-0", "under min boundary2"),
                    Arguments.of("-99", "under min boundary3")
                );
            }
        }

        @Nested
        @TestInstance(Lifecycle.PER_CLASS)
        @DisplayName("validation for numbers")
        class DescribeValidateNumbers {

            @DisplayName("wrong input of")
            @ParameterizedTest(name = "{1}")
            @MethodSource("invalidParameters")
            void validateNumbers(String input, String message) {
                Assertions.assertThatThrownBy(() -> {

                    BonusNumber bonusNumber = new BonusNumber(input, null);

                }).hasMessageContaining("[ERROR] The bonus number must consists validate numbers.");

            }

            Stream<Arguments> invalidParameters() throws Throwable {
                return Stream.of(
                    Arguments.of("A", "alphabet uppercase"),
                    Arguments.of("a", "alphabet lowercase"),
                    Arguments.of("AAAAAAAAAAAA", "multi alphabet uppercase"),
                    Arguments.of("ㅁㅁㅁㅁㅁㅁㅁㅁ", "korean"),
                    Arguments.of("123123123123", "alphabet lowercase"),
                    Arguments.of("9 9 9 9 9 9 9", "alphabet lowercase"),
                    Arguments.of("0", "zero"),
                    Arguments.of("46", "over max boundary1"),
                    Arguments.of("99", "over max boundary2"),
                    Arguments.of(" ", "white space"),
                    Arguments.of("~!@#$%^&*()_+", "special1"),
                    Arguments.of("[][][][][][][][[][][][][][][][]", "special2"),
                    Arguments.of("!@#%ADS 23 @#$^5g4g^*1U >Y >?<we_fq", "mixed"),
                    Arguments.of("", "empty"),
                    Arguments.of(null, "NULL")
                );
            }
        }

        @Nested
        @TestInstance(Lifecycle.PER_CLASS)
        @DisplayName("validation for duplicate with WinningNumber")
        class DescribeDuplicateWithWinningNumber {

            @DisplayName("wrong input of")
            @ParameterizedTest(name = "{1}")
            @MethodSource("invalidParameters")
            void validateDuplicate(String input, String message) {
                Assertions.assertThatThrownBy(() -> {

                    WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
                    BonusNumber bonusNumber = new BonusNumber(input, winningNumber);

                }).hasMessageContaining("[ERROR] The bonus number must not have"
                    + " a duplicate number with the winning number.");

            }

            Stream<Arguments> invalidParameters() throws Throwable {
                return Stream.of(
                    Arguments.of("1", "duplicate1"),
                    Arguments.of("2", "duplicate2"),
                    Arguments.of("3", "duplicate3"),
                    Arguments.of("4", "duplicate4")
                );
            }

        }
    }
}

