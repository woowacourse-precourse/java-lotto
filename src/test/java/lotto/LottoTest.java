package lotto;

import lotto.model.Lotto;
import lotto.model.User;
import lotto.validation.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    class UserTest {
        private final User user = new User();

        @DisplayName("로또 저장 테스트")
        @Test
        void addLottoTest() {
            int countLotto = user.getLottos().size();
            user.addLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
            assertThat(countLotto+1).isEqualTo(user.getLottos().size());
        }
    }

    private final InputValidation inputValidation  = new InputValidation();

    @Nested
    class validatePriceTest {

        @DisplayName("숫자인지 검증 테스트")
        @Test
        void case1() {
            assertThatThrownBy(() -> inputValidation.validatePrice("asdf"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("1000으로 나누어 떨어지는 검증 테스트")
        @Test
        void case2() {
            assertThatThrownBy(() -> inputValidation.validatePrice("1111"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class validateWinningNumbersTest {
        @DisplayName("숫자 6개와 5개의 반점으로 구분되어 있는지 검증 테스트")
        @Test
        void case1() {
            assertThatThrownBy(() -> inputValidation.validateWinningNumbers("1,2,3 4,5,6"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호 중복 검증 테스트")
        @Test
        void case2() {
            assertThatThrownBy(() -> inputValidation.validateWinningNumbers("1,2,3,3,5,6"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("0인지 검증 테스트")
        @Test
        void case3() {
            assertThatThrownBy(() -> inputValidation.validateWinningNumbers("0,2,3,4,5,6"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("45보다 작은 숫자인지 검증 테스트")
        @Test
        void cas4() {
            assertThatThrownBy(() -> inputValidation.validateWinningNumbers("1,2,3,4,5,46"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class validateBonusNumberTest {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        @DisplayName("한 자리 혹은 두 자리 숫자인지 검증 테스트")
        @Test
        void case1() {
            assertThatThrownBy(() -> inputValidation.validateBonusNumber("123", winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("45보다 작은 숫자인지 검증 테스트")
        @Test
        void case2() {
            assertThatThrownBy(() -> inputValidation.validateBonusNumber("46", winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호와 중복인지 검증 테스트")
        @Test
        void case3() {
            assertThatThrownBy(() -> inputValidation.validateBonusNumber("1", winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
