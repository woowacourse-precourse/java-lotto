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
            Arguments.of("{1,2,3,4,5,6}은 정상이다", "1,2,3,4,5,6", "7"),
            Arguments.of("{1,2,3,9,8,6}은 정상이다", "1,2,3,9,8,6", "7"),
            Arguments.of("{1,2,3,9,8,45}은 정상이다", "1,2,3,9,8,45", "7")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param1")
    @DisplayName("올바른 문자열로 isValidWinAndBonus 테스트")
    void test1(String description, String wins, String bonus) {
        Validator validator = new Validator();
        Assertions.assertDoesNotThrow(() -> validator.isValidWinAndBonus(wins, bonus));
    }

    private static Collection<Arguments> param2() {
        return Arrays.asList(
            Arguments.of("{1,2,3,4,5,i}은 비정상이다", "1,2,3,4,5,i", "7"),
            Arguments.of("{1,2,k,9,8,6}은 비정상이다", "1,2,k,9,8,6", "7"),
            Arguments.of("{1,2,3,9,8}은 비정상이다", "1,2,3,9,8", "7"),
            Arguments.of("{1,2,3,9,8,99}은 비정상이다", "1,2,3,9,8,99", "7"),
            Arguments.of("{1,2,3,9,8,46}은 비정상이다", "1,2,3,9,8,46", "7"),
            Arguments.of("{1,2,3,9,8,0}은 비정상이다", "1,2,3,9,8,0", "7"),
            Arguments.of("{1,1,1,1,1,1}은 비정상이다", "1,1,1,1,1,1", "7"),
            Arguments.of("{1,2,3,4,5,5}은 비정상이다", "1,2,3,4,5,5", "7")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param2")
    @DisplayName("올바르지 않은 wins 문자열로 isValidWinAndBonus 테스트")
    void test2(String description, String wins, String bonus) {
        Validator validator = new Validator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidWinAndBonus(wins, bonus));
    }

    private static Collection<Arguments> param3() {
        return Arrays.asList(
            Arguments.of("{1,2,3,4,5,i}은 비정상이다", "1,2,3,4,5,7", "7"),
            Arguments.of("{1,2,3,4,5,i}은 비정상이다", "1,2,3,4,25,7", "25")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param3")
    @DisplayName("중복된 숫자가 존재하는 wins,bonus로 isValidWinnings 테스트")
    void test3(String description, String wins, String bonus) {
        Validator validator = new Validator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.isValidWinAndBonus(wins, bonus));
    }
}
