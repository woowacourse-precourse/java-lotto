package lotto.validation;

import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberValidationTest {

    @Test
    @DisplayName("로또 번호의 갯수가 6이 아닌 경우 예외")
    void numberCountValid() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4);

        // when && then
        assertThatThrownBy(() -> new LottoNumberValidation(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.ERROR.getMessage());
    }

    @Test
    @DisplayName("중복된 로또 번호가 포함 된 경우 예외")
    void duplicateValid() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 4, 5);

        // when && then
        assertThatThrownBy(() -> new LottoNumberValidation(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.ERROR.getMessage());
    }

    @Test
    @DisplayName("중복된 로또 번호의 범위가 벗어난 경우 예외")
    void numberRangeValid() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 4, 46);

        // when && then
        assertThatThrownBy(() -> new LottoNumberValidation(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.ERROR.getMessage());
    }
}