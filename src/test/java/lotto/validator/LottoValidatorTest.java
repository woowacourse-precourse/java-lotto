package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoValidatorTest {

    @DisplayName("로또 번호 중복 검사")
    @Test
    void validateDuplicate() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validate(List.of(1, 1, 2, 3, 4, 5))
        );
    }

    @DisplayName("로또 번호 사이즈 검사")
    @Test
    void validateSize() {
        assertThrows(IllegalArgumentException.class,
                () -> LottoValidator.validate(List.of(1, 2, 3, 4, 5))
        );
    }

    @DisplayName("로또 번호 범위 검사")
    @Test
    void validateRange() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> LottoValidator.validate(List.of(0, 2, 3, 4, 5, 6))),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> LottoValidator.validate(List.of(1, 2, 3, 4, 5, 46)))
        );
    }
}