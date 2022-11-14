package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumber;
import lotto.validator.LottoNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Nested
    @DisplayName("사용자가 입력한 문자열이")
    class If_user_input_is {

        @Test
        @DisplayName("숫자가 아닐 경우 예외를 던진다")
        void not_numeric() {
            // given
            Lotto lotto = new Lotto("1,2,3,4,5,6");
            String input = "로또게임";

            // when, then
            assertThatThrownBy(() -> new WinningLotto(lotto, input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.THIS_INPUT_ALLOW_NUMBER.getMessage());
        }

        @Test
        @DisplayName("숫자일 경우 예외를 던지지 않는다")
        void numeric() {
            // given
            Lotto lotto = new Lotto("1,2,3,4,5,6");
            String input = "7";

            // when, then
            assertThatCode(() -> new WinningLotto(lotto, input))
                    .doesNotThrowAnyException();
        }
    }

    @Nested
    @DisplayName("입력된 보너스 번호가 로또 규칙에")
    class If_input_bonus_number {

        @Test
        @DisplayName("맞지 않으면 예외를 던진다")
        void does_not_comply_with_rule_then_throw_exception() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int bonusNumber = LottoNumber.END_NUMBER_OF_LOTTO.getNumber() + 1;

            // when, then
            assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.LOTTO_NUMBER_IS_OUT_OF_RANGE.getMessage());
        }

        @Test
        @DisplayName("맞다면 예외를 던지지 않는다")
        void does_not_comply_with_rule_then_does_not_throw_exception() {
            // given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int bonusNumber = 7;

            // when, then
            assertThatCode(() -> new WinningLotto(lotto, bonusNumber))
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
            assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
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
