package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class PrizeLottoTest {
    @DisplayName("보너스 번호가 이미 당첨 번호에 있으면 예외.")
    @Test
    void duplicatedBonusNumberTest() {
        Assertions.assertThatThrownBy(() -> new PrizeLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("invalidParameters")
    @DisplayName("당첨 번호와 보너스 번호가 잘못된 값이면 예외.")
    void invalidConstructorParameter(List<Integer> numbers, int bonusNumber) {
        Assertions.assertThatThrownBy(() -> new PrizeLotto(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidParameters() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 56), 20),
                Arguments.of(List.of(1, 1, 2, 3, 4, 5), 20),
                Arguments.of(List.of(1, 2), 40),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 67)
        );
    }
}
