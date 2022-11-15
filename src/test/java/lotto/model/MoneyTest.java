package lotto.model;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MoneyTest {

    @Nested
    @DisplayName("Money Class")
    class MoneyKoTest {

        @Nested
        @TestInstance(Lifecycle.PER_CLASS)
        @DisplayName("validation for isNumeric input of")
        class DescribeIsNumeric {

            @DisplayName("wrong input of")
            @ParameterizedTest(name = "{1}")
            @MethodSource("invalidParameters")
            void isNumeric(String input, String message) {
                Assertions.assertThatThrownBy(() -> {

                    Money money = new Money(input);

                }).hasMessageContaining("[ERROR] The money must be numeric.");

            }

            Stream<Arguments> invalidParameters() throws Throwable {
                return Stream.of(
                    Arguments.of("abcdef", "alphabet"),
                    Arguments.of("!@#$%^", "special"),
                    Arguments.of("abc!@#$%^", "alphabet and special"),
                    Arguments.of("          ", "whiteSpace"),
                    Arguments.of("!@#30000    %^", "mixed1"),
                    Arguments.of("!  @#30  %6000    %^", "mixed2"),
                    Arguments.of("[]3[]4[]6[]7[]9[]1[]0[]", "mixed3"),
                    Arguments.of("!@  #<>{}[]<>{}{}<>????1234%^", "mixed4"),
                    Arguments.of("-12-12", "number with minus1"),
                    Arguments.of("-------12", "number with minus2"),
                    Arguments.of("12------", "number with minus3"),
                    Arguments.of("-12-----12", "number with minus4"),
                    Arguments.of("", "empty"),
                    Arguments.of(null, "NULL")
                );
            }
        }

        @Nested
        @TestInstance(Lifecycle.PER_CLASS)
        @DisplayName("validation for sign input of")
        class DescribeValidateSign {

            @DisplayName("wrong input of")
            @ParameterizedTest(name = "{1}")
            @MethodSource("invalidParameters")
            void isNumeric(String input, String message) {
                Assertions.assertThatThrownBy(() -> {

                    Money money = new Money(input);

                }).hasMessageContaining("[ERROR] The money must be positive.");

            }

            Stream<Arguments> invalidParameters() throws Throwable {
                return Stream.of(
                    Arguments.of("-1", "negative1"),
                    Arguments.of("-10", "negative2"),
                    Arguments.of("-100", "negative3"),
                    Arguments.of("-1000", "negative4"),
                    Arguments.of("-10000", "negative5")
                );
            }
        }

        @Nested
        @TestInstance(Lifecycle.PER_CLASS)
        @DisplayName("validation for thousands input of")
        class DescribeValidateThousand {

            @DisplayName("single digit of")
            @ParameterizedTest(name = "{1}")
            @MethodSource("invalidParameters1")
            void validateThousandSingleDigit(String input, String message) {
                Assertions.assertThatThrownBy(() -> {

                    Money money = new Money(input);

                }).hasMessageContaining("[ERROR] The money must be divided by a thousand");
            }

            Stream<Arguments> invalidParameters1() throws Throwable {
                return Stream.of(
                    Arguments.of("1", "1"),
                    Arguments.of("2", "2"),
                    Arguments.of("3", "3"),
                    Arguments.of("4", "4"),
                    Arguments.of("5", "5"),
                    Arguments.of("6", "6"),
                    Arguments.of("7", "7"),
                    Arguments.of("8", "8"),
                    Arguments.of("9", "9")
                );
            }

            @DisplayName("double digit of")
            @ParameterizedTest(name = "{1}")
            @MethodSource("invalidParameters2")
            void validateThousandDoubleDigit(String input, String message) {
                Assertions.assertThatThrownBy(() -> {

                    Money money = new Money(input);

                }).hasMessageContaining("[ERROR] The money must be divided by a thousand");
            }

            Stream<Arguments> invalidParameters2() throws Throwable {
                return Stream.of(
                    Arguments.of("10", "10"),
                    Arguments.of("12", "12"),
                    Arguments.of("33", "33"),
                    Arguments.of("42", "42"),
                    Arguments.of("59", "59"),
                    Arguments.of("67", "67"),
                    Arguments.of("74", "74"),
                    Arguments.of("89", "89"),
                    Arguments.of("90", "90")
                );
            }

            @DisplayName("three digit of")
            @ParameterizedTest(name = "{1}")
            @MethodSource("invalidParameters3")
            void validateThousandThreeDigit(String input, String message) {
                Assertions.assertThatThrownBy(() -> {
                    Money money = new Money(input);
                }).hasMessageContaining("[ERROR] The money must be divided by a thousand");
            }

            Stream<Arguments> invalidParameters3() throws Throwable {
                return Stream.of(
                    Arguments.of("100", "100"),
                    Arguments.of("121", "121"),
                    Arguments.of("332", "332"),
                    Arguments.of("429", "429"),
                    Arguments.of("591", "591"),
                    Arguments.of("670", "670"),
                    Arguments.of("741", "741"),
                    Arguments.of("892", "892"),
                    Arguments.of("904", "904")
                );
            }

            @DisplayName("four digit of")
            @ParameterizedTest(name = "{1}")
            @MethodSource("invalidParameters4")
            void validateThousandFourDigit(String input, String message) {
                Assertions.assertThatThrownBy(() -> {
                    Money money = new Money(input);
                }).hasMessageContaining("[ERROR] The money must be divided by a thousand");
            }

            Stream<Arguments> invalidParameters4() throws Throwable {
                return Stream.of(
                    Arguments.of("1001", "1001"),
                    Arguments.of("1214", "1214"),
                    Arguments.of("3322", "3322"),
                    Arguments.of("4298", "4298"),
                    Arguments.of("5917", "5917"),
                    Arguments.of("6704", "6704"),
                    Arguments.of("7412", "7412"),
                    Arguments.of("8928", "8928"),
                    Arguments.of("9040", "9040")
                );
            }
        }
    }
}