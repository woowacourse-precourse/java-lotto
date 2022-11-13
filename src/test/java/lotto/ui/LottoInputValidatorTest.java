package lotto.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoInputValidatorTest {

    private LottoValidator validator = new LottoValidator();

    @DisplayName("구입금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputNotNumericPrice() {
        assertThatThrownBy(() -> validator.validatePrice("dsadsa"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validatePrice("!#!#"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validatePrice("15!A#1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000단위가 아니면 예외가 발생한다.")
    @Test
    void inputNot1000Price() {
        assertThatThrownBy(() -> validator.validatePrice("5500"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validatePrice("5001"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validatePrice("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000단위 숫자면 예외가 발생하지 않는다.")
    @Test
    void input1000Price() {
        validator.validatePrice("1000");
        validator.validatePrice("2000");
        validator.validatePrice("3000");
        validator.validatePrice("15000");
        validator.validatePrice("58000");
    }

    @DisplayName("당첨 번호 구분자의 구분자가 ','가 아니면 예외가 발생한다.")
    @Test
    void inputInvalidSepOfWinningNumbers() {
        assertThatThrownBy(() -> validator.validateWinningNumbers("1;2;3;8;9;4"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateWinningNumbers("1.2.3.4.5.6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateWinningNumbers("14`41`9`5`3`1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6자리가 아니면 예외가 발생한다.")
    @Test
    void inputWinningNumbersOverSize() {
        assertThatThrownBy(() -> validator.validateWinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateWinningNumbers("1,2,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputNotNumericWinningNumbers() {
        assertThatThrownBy(() -> validator.validateWinningNumbers("1,a,3,4,6,7"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateWinningNumbers("1,2,5,6,7,FD"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 1~45 범위가 아니면 예외가 발생한다..")
    @Test
    void inputNotRange1To45WinningNumbers() {
        assertThatThrownBy(() -> validator.validateWinningNumbers("1,2,3,4,62,7"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateWinningNumbers("1,2,46,4,42,7"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateWinningNumbers("1,2,40,4,42,0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 숫자가 중복되면 예외가 발생한다.")
    @Test
    void inputDuplicationWinningNumbers() {
        assertThatThrownBy(() -> validator.validateWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateWinningNumbers("1,1,1,1,42,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 정상 케이스 테스트")
    @Test
    void inputWinningNumbers() {
        validator.validateWinningNumbers("1,2,3,4,5,6");
        validator.validateWinningNumbers("15,45,5,1,9,2");
        validator.validateWinningNumbers("9,12,39,27,14,2");
        validator.validateWinningNumbers("30,5,36,19,22,44");
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputNotNumericBonusNumbers() {
        assertThatThrownBy(() -> validator.validateBonusNumber("5dasd"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateBonusNumber("1,7,9,2,4,8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 1~45 범위가 아니면 예외가 발생한다..")
    @Test
    void inputNotRange1To45BonusNumbers() {
        assertThatThrownBy(() -> validator.validateBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위 숫자면 예외가 발생하지 않는다")
    @Test
    void inputNumericBonusNumbers() {
        validator.validateBonusNumber("1");
        validator.validateBonusNumber("8");
        validator.validateBonusNumber("19");
        validator.validateBonusNumber("45");
    }
}