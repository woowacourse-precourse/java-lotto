package lotto;

import java.util.Arrays;
import java.util.Collection;
import lotto.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidatiorTest {
    private static Collection<Arguments> param1() {
        return Arrays.asList(
            Arguments.of("{1,2,3,4,5,6}은 정상이다", "1,2,3,4,5,6"),
            Arguments.of("{1,2,3,9,8,6}은 정상이다", "1,2,3,9,8,6"),
            Arguments.of("{1,2,3,9,8,45}은 정상이다", "1,2,3,9,8,45")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param1")
    @DisplayName("올바른 문자열로 isValidWinnings 테스트")
    void test1(String description, String wins) {
        Validator validator = new Validator();
        Assertions.assertDoesNotThrow(() -> validator.isValidWinnings(wins));
    }

    private static Collection<Arguments> param2() {
        return Arrays.asList(
            Arguments.of("{1,2,3,4,5,i}은 비정상이다", "1,2,3,4,5,i"),
            Arguments.of("{1,2,k,9,8,6}은 비정상이다", "1,2,k,9,8,6"),
            Arguments.of("{1,2,3,9,8}은 비정상이다", "1,2,3,9,8"),
            Arguments.of("{1,2,3,9,8,99}은 비정상이다", "1,2,3,9,8,99"),
            Arguments.of("{1,2,3,9,8,46}은 비정상이다", "1,2,3,9,8,46"),
            Arguments.of("{1,2,3,9,8,0}은 비정상이다", "1,2,3,9,8,0")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param2")
    @DisplayName("올바르지 않은 문자열로 isValidWinnings 테스트")
    void test2(String description, String wins) {
        Validator validator = new Validator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidWinnings(wins));
    }
}
