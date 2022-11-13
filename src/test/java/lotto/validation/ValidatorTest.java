package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("구입금액의 첫 자리가 0일 경우 예외가 발생한다.")
    @Test
    void createZeroStartNumber() {
        String money = "01000";
        assertThatThrownBy(() -> Validator.validateInputMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("첫 자리는 0을 입력할 수 없습니다.");
    }

    @DisplayName("구입금액이 1000으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    @Test
    void createDoesntDividedByThousand() {
        int money = 1500;
        assertThatThrownBy(() -> Validator.isDividedByThousand(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위로 입력해주세요.");
    }

    @DisplayName("구입금액을 숫자가 아닌 다른 문자로 입력할 경우 예외가 발생한다.")
    @Test
    void createIncorrectMoney() {
        String money = "a1000";
        assertThatThrownBy(() -> Validator.validateInputMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }

    @DisplayName("보너스 번호를 숫자가 아닌 다른 문자로 입력할 경우 예외가 발생한다.")
    @Test
    void createIncorrectBonusNumberPattern() {
        String money = "a1000";
        assertThatThrownBy(() -> Validator.isCorrectBonusNumberPattern(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요.");
    }

    @DisplayName("로또 당첨 번호와 중복되는 보너스 번호를 입력할 경우 예외가 발생한다.")
    @Test
    void createDuplicatedBonusNumber() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        assertThatThrownBy(() -> Validator.validateBonusNumber(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자는 입력할 수 없습니다.");
    }

    @DisplayName("1~45의 보너스 번호를 입력하지 않을 경우 예외가 발생한다.")
    @Test
    void createOverBonusNumber() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 100;
        assertThatThrownBy(() -> Validator.validateBonusNumber(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45 사이의 숫자여야 합니다.");
    }
}