package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @DisplayName("숫자 형식이 아닌 경우 예외가 발생한다.")
    @Test
    void inputNotNumeric() {
        Validation validation = new Validation();
        assertThatThrownBy(() -> validation.checkNumeric("abc"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백일 경우 예외가 발생한다.")
    @Test
    void inputBlank() {
        Validation validation = new Validation();
        assertThatThrownBy(() -> validation.checkNull("   "))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열이 비어있을 경우 예외가 발생한다.")
    @Test
    void inputNull() {
        Validation validation = new Validation();
        assertThatThrownBy(() -> validation.checkNull(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1보다 작은 번호에 대해 예외가 발생한다.")
    @Test
    void inputUnderLottoNumberRange() {
        Validation validation = new Validation();
        assertThatThrownBy(() -> validation.checkNumberInRange(-4))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("45보다 큰 번호에 대해 예외가 발생한다.")
    @Test
    void inputOverLottoNumberRange() {
        Validation validation = new Validation();
        assertThatThrownBy(() -> validation.checkNumberInRange(50))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000으로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void inputNotDividable() {
        Validation validation = new Validation();
        assertThatThrownBy(() -> validation.checkDividable(12345))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 쉼표(,)로 구분되지 않으면 예외가 발생한다.")
    @Test
    void inputSplitException() {
        Validation validation = new Validation();
        assertThatThrownBy(() -> validation.checkWinningFormat("1 2 3 4 5"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputIntegerException() {
        Validation validation = new Validation();
        assertThatThrownBy(() -> validation.checkWinningFormat("1,2,3,a,b,6"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 숫자가 6개가 아니면 예외가 발생한다.")
    @Test
    void inputLengthException() {
        Validation validation = new Validation();
        assertThatThrownBy(() -> validation.checkWinningFormat("1,2,3,4"))
            .isInstanceOf(IllegalArgumentException.class);
    }

}