package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoNumberValidatorTest {

    @Nested
    @DisplayName("로또를 만들 때")
    class If_make_lotto {

        @Test
        @DisplayName("중복된 숫자를 입력하면 예외를 던진다")
        void with_duplicate_number_then_throw_exception() {
            // given
            List<Integer> numbers = List.of(1, 1, 1, 1, 1, 1);

            // when, then
            assertThatThrownBy(() -> LottoNumberValidator.validateExistDuplicateNumber(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.CAN_NOT_EXIST_DUPLICATE_NUMBER_IN_LOTTO.getMessage());
        }

        @Test
        @DisplayName("중복된 숫자가 입력하지 않으면 예외를 던지지 않는다")
        void without_duplicate_number_then_throw_exception() {
            // given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

            // when, then
            assertThatCode(() -> LottoNumberValidator.validateExistDuplicateNumber(numbers))
                    .doesNotThrowAnyException();
        }
    }
}
