package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoNumberValidatorTest {

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
