package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumber;
import lotto.domain.Lotto;
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

    @Nested
    @DisplayName("로또에 넣을 번호가")
    class lotto_number {

        @Test
        @DisplayName("규칙에서 정한 범위 밖이면 예외를 던진다")
        void is_outside_limit_prescribed_rule() {
            // given
            List<Integer> numbers = List.of(LottoNumber.END_NUMBER_OF_LOTTO.getNumber() + 1);

            // when, then
            assertThatThrownBy(() -> LottoNumberValidator.validateRangeOfNumber(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.LOTTO_NUMBER_IS_OUT_OF_RANGE.getMessage());
        }

        @Test
        @DisplayName("규칙에서 정한 범위 안이면 예외를 던지지 않는다")
        void is_inside_limit_prescribed_rule() {
            // given
            List<Integer> numbers = List.of(
                    LottoNumber.START_NUMBER_OF_LOTTO.getNumber(),
                    LottoNumber.END_NUMBER_OF_LOTTO.getNumber()
            );

            // when, then
            assertThatCode(() -> LottoNumberValidator.validateRangeOfNumber(numbers))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("보너스 번호가 로또 번호와")
    class If_bonus_number_and_lotto_numbers {

        @Test
        @DisplayName("겹친다면 예외를 던진다")
        void overlap_then_throw_exception() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int bonusNumber = 1;

            // when, then
            assertThatThrownBy(() -> LottoNumberValidator.validateBonusNumberAndLottoAreDuplicate(lotto, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BONUS_NUMBER_AND_WINNING_LOTTO_NUMBERS_ARE_DUPLICATE.getMessage());
        }

        @Test
        @DisplayName("겹치지 않으면 예외를 던지지 않는다")
        void does_not_overlap_then_throw_exception() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int bonusNumber = 7;

            // when, then
            assertThatCode(() -> LottoNumberValidator.validateBonusNumberAndLottoAreDuplicate(lotto, bonusNumber))
                    .doesNotThrowAnyException();
        }
    }
}
