package lotto;

import lotto.model.BonusNumber;
import lotto.model.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

    @DisplayName("보너스 번호가 당첨 번호와 중복된 숫자면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new BonusNumber("1", winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 값이 45보다 큰 값이면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverLimit() {
        assertThatThrownBy(() -> new BonusNumber("46", winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 값이 1보다 작은 값이면 예외가 발생한다.")
    @Test
    void createBonusNumberByUnderLimit() {
        assertThatThrownBy(() -> new BonusNumber("0", winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 규격 이외의 값이 들어가면 예외가 발생한다.")
    @Test
    void createBonusNumberByInvalidValue() {
        assertThatThrownBy(() -> new BonusNumber("이상한값", winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
