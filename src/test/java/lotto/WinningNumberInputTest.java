package lotto;

import lotto.exception.ExceptionValidation;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberInputTest {

    @DisplayName("로또가 6자리가 아니라면 예외 발생")
    @Test
    void checksize() {
        assertThatThrownBy(() -> ExceptionValidation.inputException(List.of(1,2,3,4,5)))
                .hasMessageContaining("[ERROR] 6자리의 수를 입력해주세요.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 수가 입력되었다면 예외 발생")
    @Test
    void checkduplicate() {
        assertThatThrownBy(() -> ExceptionValidation.inputException(List.of(1,2,2,3,3,4)))
                .hasMessageContaining("[ERROR] 중복되지 않는 6자리 수를 입력해주세요.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1부터 45까지의 수가 아닐 경우 예외 발생")
    @Test
    void checkrange() {
        assertThatThrownBy(() -> ExceptionValidation.inputException(List.of(1,2,3,4,5,46)))
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 보너스 번호가 포함되어있다면 예외 발생")
    @Test
    void checkDuplicateBonus(){
        int bonus = 6;
        List<Integer> winning = List.of(1,2,3,4,5,6);
        assertThatThrownBy(()->ExceptionValidation.bonusException(bonus, winning))
                .hasMessageContaining("[ERROR] 당첨 번호 6자리와 다른 수를 입력해주세요.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 보너스 번호가 포함되어있다면 예외 발생")
    @Test
    void checkRangeBonus(){
        int bonus = 46;
        List<Integer> winning = List.of(1,2,3,4,5,6);
        assertThatThrownBy(()->ExceptionValidation.bonusException(bonus, winning))
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }
}