package lotto.validator;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusNumberValidatorTest {

    @DisplayName("보너스 넘버 입력 테스트")
    @ParameterizedTest
    @MethodSource("provideWinningLotto")
    void bonusNumberValidateTest(Lotto lotto) {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> BonusNumberValidator.validate("1", lotto)),
                () -> assertThrows(IllegalArgumentException.class, () -> BonusNumberValidator.validate("asd", lotto))
        );
    }

    private static Stream<Arguments> provideWinningLotto() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7))),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8))),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 9))),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 10)))
        );
    }

}