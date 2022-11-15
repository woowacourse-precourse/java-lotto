package lotto.validator;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoValidatorTest {

    @DisplayName("로또 번호 중복 검사")
    @Test
    void validateDuplicate() {
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(1, 1, 2, 3, 4, 5))
        );
    }

    @DisplayName("로또 번호 사이즈 검사")
    @Test
    void validateSize() {
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(1, 2, 3, 4, 5))
        );
    }

    @DisplayName("로또 번호 범위 검사")
    @ParameterizedTest
    @MethodSource("provideLotto")
    void validateRange(List<Integer> list) {
        assertThrows(IllegalArgumentException.class, () -> new Lotto(list));
    }

    private static Stream<Arguments> provideLotto() {
        return Stream.of(
                Arguments.of(List.of(0, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 46)),
                Arguments.of(List.of(-1, 2, 3, 4, 5, 6))
        );
    }
}