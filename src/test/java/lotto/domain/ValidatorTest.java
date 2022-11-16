package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ValidatorTest {

    @ParameterizedTest(name = "유효한 값이면 예외가 발생하지 않는다")
    @MethodSource
    void validate(List<Integer> numbers) {
        assertDoesNotThrow(() -> Validator.validate(numbers));
    }

    private static Stream<List<Integer>> validate() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 13, 11, 5, 6),
                List.of(1, 2, 3, 9, 15, 44));
    }

    @ParameterizedTest(name = "유효하지 않은 값이면 예외가 발생한다")
    @MethodSource
    void validate_throws_error(List<Integer> numbers) {
        assertThrows(IllegalArgumentException.class, () -> Validator.validate(numbers));
    }

    private static Stream<List<Integer>> validate_throws_error() {
        return Stream.of(
                List.of(1, 2, 1, 4, 5, 6),
                List.of(1, 2, 0, 11, 5, 6),
                List.of(1, 2, 15, 44));
    }

}