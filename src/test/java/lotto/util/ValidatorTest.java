package lotto.util;

import lotto.util.Validator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    @ParameterizedTest(name = "숫자 갯수 테스트")
    @MethodSource("isNotCorrectLottoNumberSizeData")
    void isNotCorrectLottoNumberSize(List<Integer> numbers, boolean deduplicate, boolean result) {
        assertThat(Validator.isNotCorrectLottoNumberSize(numbers, deduplicate)).isEqualTo(result);
    }

    static Stream<Arguments> isNotCorrectLottoNumberSizeData() {
        return Stream.of(
                Arguments.of(List.of(1, 2), false, true),
                Arguments.of(List.of(1, 1, 1, 1, 1, 1), false, false),
                Arguments.of(List.of(1, 1, 1, 1, 1, 1), true, true),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), true, false)
        );
    }

    @ParameterizedTest(name = "대량의 숫자 범위 테스트")
    @MethodSource("hasNotCorrectRangeNumbersData")
    void hasNotCorrectRangeNumbers(List<Integer> numbers, boolean result) {
        assertThat(Validator.hasNotCorrectRangeNumbers(numbers)).isEqualTo(result);
    }

    static Stream<Arguments> hasNotCorrectRangeNumbersData() {
        return Stream.of(
                Arguments.of(List.of(-1, 2), true),
                Arguments.of(List.of(1, 47), true),
                Arguments.of(List.of(1, 45), false),
                Arguments.of(List.of(2, 43), false)
        );
    }

    @ParameterizedTest(name = "특정 숫자 범위 테스트")
    @MethodSource("hasNotCorrectRangeNumberData")
    void hasNotCorrectRangeNumber() {

    }

    static Stream<Arguments> hasNotCorrectRangeNumberData() {
        return Stream.of(
                Arguments.of(56, false),
                Arguments.of(-1, false),
                Arguments.of(1, true),
                Arguments.of(45, true),
                Arguments.of(2, true)
        );
    }

    @ParameterizedTest(name = "잔돈이 남는지 테스트")
    @MethodSource("hasLeftMoneyAfterBuyLottoData")
    void hasLeftMoneyAfterBuyLotto(int money, boolean result) {
        assertThat(Validator.hasLeftMoneyAfterBuyLotto(money)).isEqualTo(result);
    }

    static Stream<Arguments> hasLeftMoneyAfterBuyLottoData() {
        return Stream.of(
                Arguments.of(56, true),
                Arguments.of(1000, false),
                Arguments.of(12_000, false),
                Arguments.of(-10_000, false)
        );
    }

    @ParameterizedTest(name = "숫자 음수 테스트")
    @MethodSource("isNegativeNumberData")
    void isNegativeNumber(int number, boolean result) {
        assertThat(Validator.isNegativeNumber(number)).isEqualTo(result);
    }

    static Stream<Arguments> isNegativeNumberData() {
        return Stream.of(
                Arguments.of(56, false),
                Arguments.of(-1, true),
                Arguments.of(0, false)
        );
    }

}