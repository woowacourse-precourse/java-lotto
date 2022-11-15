package lotto.domain.user;

import lotto.exception.InputException;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserLottoTest {

    @DisplayName("보너스 번호 예외 처리 테스트")
    @Nested
    class BonusLottoException {

        @DisplayName("보너스 번호가 숫자가 아니면 예외를 터트린다.")
        @Test
        void bonusLottoNotDigitException() {
            String bonusNumber = "$";
            System.setIn(generateUserInput(bonusNumber));

            assertThatThrownBy(InputView::inputUserBonusNumber)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.BONUS_LOTTO_INVALID_FORM.message());
        }

        @DisplayName("보너스 번호가 1개가 아니면 예외를 터트린다.")
        @Test
        void bonusLottoInvalidCountException() {
            String bonusNumber = "1,3";
            System.setIn(generateUserInput(bonusNumber));

            assertThatThrownBy(InputView::inputUserBonusNumber)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.BONUS_LOTTO_INVALID_FORM.message());
        }

        @DisplayName("보너스 번호가 1 - 45 사이가 아니면 예외를 터트린다.")
        @Test
        void bonusLottoInvalidRangeException() {
            List<Integer> winNumbers = List.of(1,2,3,4,10,8);
            int bonusNumber = 67;

            assertThatThrownBy(() -> new UserLotto(winNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.BONUS_LOTTO_INVALID_FORM.message());
        }
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
