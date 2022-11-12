package lotto.domain;

import lotto.exception.InputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class UserLottoTest {

    @DisplayName("사용자 입력 예외 처리 테스트")
    @Nested
    class Exception {

        @DisplayName("당첨 번호가 쉼표로 구분되어 있지 않은 경우 예외를 터트린다.")
        @Test
        void lottoCommaException() {
            String winNumbers = "1 2 3 4";
            String bonusNumber = "2";

            Assertions.assertThatThrownBy( () -> new UserLotto(winNumbers, bonusNumber) )
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.INPUT_INVALID_DIGIT_RANGE.message());
        }

        @DisplayName("당첨 번호에 특수문자나 문자가 포함되어 있는 경우 예외를 터트린다.")
        @Test
        void lottoNotDigitException() {
            String winNumbers = "1,@,A,4";
            String bonusNumber = "2";

            Assertions.assertThatThrownBy( () -> new UserLotto(winNumbers, bonusNumber) )
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.INPUT_INVALID_DIGIT_RANGE.message());
        }

        @DisplayName("당천 번호가 1-45 숫자가 아닌 경우 예외를 터트린다.")
        @Test
        void lottoInvalidRangeException() {
            String winNumbers = "1,66,13,4";
            String bonusNumber = "2";

            Assertions.assertThatThrownBy( () -> new UserLotto(winNumbers, bonusNumber) )
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.INPUT_INVALID_DIGIT_RANGE.message());
        }
    }
}
