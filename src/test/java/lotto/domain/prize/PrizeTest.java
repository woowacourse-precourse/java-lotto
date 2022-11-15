package lotto.domain.prize;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @DisplayName("6개 이상의 당첨번호가 입력되면 예외가 발생한다.")
    @Test
    void checkOverSixNumbers() {
        assertThatThrownBy(() -> new Prize("1,2,3,4,5,6,7", "8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개 이하의 당첨번호가 입력되면 예외가 발생한다.")
    @Test
    void checkUnderSixNumbers() {
        assertThatThrownBy(() -> new Prize("1,2,3,4,5", "8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void notContainNumbers() {
        assertThatThrownBy(() -> new Prize("1,2,3,four,5,6", "8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void correctRangeOfPrizeNumber() {
        assertThatThrownBy(() -> new Prize("1,2,3,100,5,6", "8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void hasDuplicatedInPrizeNumber() {
        assertThatThrownBy(() -> new Prize("3,8,9,9,24,36", "41"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void checkBonusInputIsNumber() {
        assertThatThrownBy(() -> new Prize("1,2,3,4,5,6", "AA"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void correctRangeOfBonusNumber() {
        assertThatThrownBy(() -> new Prize("1,2,3,4,5,6", "99"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호의 숫자와 중복되면 예외가 발생한다.")
    @Test
    void hasDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new Prize("7,12,33,34,39,45", "12"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}