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

class WinningNumberTest {

    @Nested
    @DisplayName("WinningNumber Class")
    class WinningNumberKoTest {

        @Nested
        @TestInstance(Lifecycle.PER_CLASS)
        @DisplayName("validation for sign")
        class DescribeValidateSign {

            @DisplayName("wrong input of")
            @ParameterizedTest(name = "{1}")
            @MethodSource("invalidParameters")
            void validateSign(String input, String message) {
                Assertions.assertThatThrownBy(() -> {

                    WinningNumber winningNumber = new WinningNumber(input);

                }).hasMessageContaining("[ERROR] The winning number must be positive");

            }

            Stream<Arguments> invalidParameters() throws Throwable {
                return Stream.of(
                    Arguments.of("-1,-2,-3,-45,-5,-6", "under min boundary1"),
                    Arguments.of("-0,-2,-3,-4,-5,-6", "under min boundary2"),
                    Arguments.of("-99,-99,-99,-99,-99,-99", "under min boundary3")
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

                    WinningNumber winningNumber = new WinningNumber(input);

                }).hasMessageContaining("[ERROR] The winning number must consists validate numbers.");

            }

            Stream<Arguments> invalidParameters() throws Throwable {
                return Stream.of(
                    Arguments.of("A,B,C,D,E,F", "alphabet uppercase"),
                    Arguments.of("a,b,c,d,e,f", "alphabet lowercase"),
                    Arguments.of("0,0,0,0,0,0", "zero"),
                    Arguments.of("0,1,2,3,4,5", "zero with numbers"),
                    Arguments.of("46,47,48,49,50,51", "over max boundary1"),
                    Arguments.of("99,99,99,99,99,99", "over max boundary2"),
                    Arguments.of(null, "NULL")
                );
            }
        }

        @Nested
        @TestInstance(Lifecycle.PER_CLASS)
        @DisplayName("validation for delimiter")
        class DescribeValidateDelimiters {

            @DisplayName("wrong input of")
            @ParameterizedTest(name = "{1}")
            @MethodSource("invalidParameters")
            void validateDelimiters(String input, String message) {
                Assertions.assertThatThrownBy(() -> {

                    WinningNumber winningNumber = new WinningNumber(input);

                }).hasMessageContaining("[ERROR] The delimiter must be in correct format.");

            }

            Stream<Arguments> invalidParameters() throws Throwable {
                return Stream.of(

                    Arguments.of("           ", "only white spaces"),
                    Arguments.of("abcdefABCDEF", "only alphabet"),
                    Arguments.of("1 2 3 4 5 6", "white spaces"),
                    Arguments.of("1!2@3#4$5%6", "special"),
                    Arguments.of("!@#%ADS 23 @#$^5g4g^*1U >Y >?<we_fq", "mixed"),
                    Arguments.of("", "empty")
                );
            }
        }
    }
}
