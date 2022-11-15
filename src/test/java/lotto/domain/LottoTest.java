package lotto.domain;

import lotto.exception.InputException;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void init() {
        lotto = new Lotto(List.of(6, 1, 2, 3, 32, 8));
    }

    @DisplayName("보너스 번호가 당첨되지 않은 경우 거짓을 반환한다.")
    @Test
    void getBonusNumNotMatch() {
        int bonusNum = 7;

        boolean bonus = lotto.hasBonusNumber(bonusNum);

        assertThat(bonus).isFalse();
    }

    @DisplayName("보너스 번호가 당첨된 경우 참을 반환한다.")
    @Test
    void getBonusNumMatch() {
        int bonusNum = 32;

        boolean bonus = lotto.hasBonusNumber(bonusNum);

        assertThat(bonus).isTrue();
    }

    @DisplayName("당첨 번호 숫자 예외 처리 테스트")
    @Nested
    class LottoNumberException {

        @DisplayName("당첨 번호가 6개가 아닐 경우 예외를 터트린다.")
        @Test
        void lottoInvalidCountException() {
            List<Integer> winNumbers = List.of(1,2,3,5,8,9,1);
            int bonusNumber = 2;

            Assertions.assertThatThrownBy( () -> new UserLotto(winNumbers, bonusNumber) )
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.LOTTO_INVALID_COUNT.message());
        }

        @DisplayName("당천 번호가 1-45 숫자가 아닌 경우 예외를 터트린다.")
        @Test
        void lottoInvalidRangeException() {
            List<Integer> winNumbers = List.of(1,66,0,4,3,7);
            int bonusNumber = 2;

            Assertions.assertThatThrownBy( () -> new UserLotto(winNumbers, bonusNumber) )
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.LOTTO_INVALID_RANGE.message());
        }

        @DisplayName("당천 번호에 중복이 있으면 예외를 터트린다.")
        @Test
        void lottoDuplicateException() {
            List<Integer> winNumbers = List.of(1,1,3,4,10,8);
            int bonusNumber = 2;

            Assertions.assertThatThrownBy( () -> new UserLotto(winNumbers, bonusNumber) )
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.LOTTO_DUPLICATE_DIGIT.message());
        }
    }

    @DisplayName("당첨 번호 문자열 예외 처리 테스트")
    @Nested
    class LottoStringException {

        @DisplayName("당첨 번호가 쉼표로 구분되어 있지 않은 경우 예외를 터트린다.")
        @Test
        void lottoCommaException() {
            String winNumbers = "1 2 3 4";
            System.setIn(generateUserInput(winNumbers));

            Assertions.assertThatThrownBy(InputView::inputUserWinNumber)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.LOTTO_INVALID_FORM.message());
        }

        @DisplayName("당첨 번호에 특수문자나 문자가 포함되어 있는 경우 예외를 터트린다.")
        @Test
        void lottoNotDigitException() {
            String winNumbers = "1,@,A,4";
            System.setIn(generateUserInput(winNumbers));

            Assertions.assertThatThrownBy(InputView::inputUserWinNumber)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(InputException.LOTTO_INVALID_FORM.message());
        }
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
