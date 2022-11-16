package lotto.util;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidateTest {

    private static final String ERROR_MESSAGE_NOT_INT = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_NOT_PROPER_AMOUNT = "[ERROR] 구입 금액은 1000원 단위로 입력할 수 있습니다.";
    private static final String ERROR_MESSAGE_NOT_PROPER_WINNING_NUMBER_COUNT = "[ERROR] 6개의 숫자를 입력해야 합니다.";
    private static final String ERROR_MESSAGE_NOT_INT_BETWEEN_COMMA = "[ERROR] 각 쉼표 사이에 숫자만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_NUMBER_DUPLICATE = "[ERROR] 각 숫자는 중복될 수 없습니다.";
    private static final String ERROR_MESSAGE_NOT_PROPER_NUMBER_RANGE = "[ERROR] 1~45 사이의 수를 입력해야 합니다.";

    private InputValidate inputValidate = new InputValidate();

    @DisplayName("validateInputAmount메서드에 올바른 구매 금액이 들어가면 예외가 발생하지 않는다.")
    @Test
    void validateInputAmount_메서드_올바른_구매_금액() {
        assertThatCode(() -> inputValidate.validateInputAmount("14000"))
                .doesNotThrowAnyException();
    }

    @DisplayName("validateInputAmount메서드에 숫자 외의 문자가 들어가면 예외가 발생한다.")
    @Test
    void validateInputAmount_메서드_숫자_외의_문자() {
        assertThatThrownBy(() -> inputValidate.validateInputAmount("1400원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_NOT_INT);
    }

    @DisplayName("validateInputAmount메서드에 올바르지 않은 단위의 금액이 들어가면 예외가 발생한다.")
    @Test
    void validateInputAmount_메서드_올바르지_않은_금액_단위() {
        assertThatThrownBy(() -> inputValidate.validateInputAmount("14052"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_NOT_PROPER_AMOUNT);
    }

    @DisplayName("당첨 번호에 6개의 숫자가 포함되지 않으면 예외가 발생한다.")
    @Test
    void validateInputWinningNumber_메서드_5개의_숫자_포함() {
        assertThatThrownBy(() -> inputValidate.validateInputWinningNumber("1,4,1,5,2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_NOT_PROPER_WINNING_NUMBER_COUNT);
    }

    @DisplayName("당첨 번호에 6자리에 숫자 외의 값이 오면 예외가 발생한다.")
    @Test
    void validateInputWinningNumber_메서드_숫자_외의_값_포함() {
        assertThatThrownBy(() -> inputValidate.validateInputWinningNumber("1,4,1,안녕,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_NOT_INT_BETWEEN_COMMA);
    }

    @DisplayName("당첨 번호 각 숫자는 하나라도 중복되면 예외가 발생한다.")
    @Test
    void validateInputWinningNumber_메서드_숫자_중복() {
        assertThatThrownBy(() -> inputValidate.validateInputWinningNumber("1,4,1,1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_NUMBER_DUPLICATE);
    }

    @DisplayName("당첨 번호에 범위를 벗어난 숫자가 들어올 시 예외가 발생한다")
    @Test
    void validateInputWinningNumber_메서드_올바르지_않은_숫자_범위() {
        assertThatThrownBy(() -> inputValidate.validateInputWinningNumber("1,4,0,23,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_NOT_PROPER_NUMBER_RANGE);
    }

    @DisplayName("올바른 보너스 번호가 들어올 시 예외가 발생하지 않는다.")
    @Test
    void validateInputBousNumber_메서드_올바른_값() {
        assertThatCode(() -> inputValidate.validateInputBonusNumber("14"))
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호에 숫자가 아닌 값이 들어올 시 예외가 발생한다.")
    @Test
    void validateInputBousNumber_메서드_숫자가_아닌_값() {
        assertThatThrownBy(() -> inputValidate.validateInputBonusNumber("이십"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_NOT_INT);
    }

    @DisplayName("보너스 번호에 범위를 벗어난 숫자가 들어올 시 예외가 발생한다.")
    @Test
    void validateInputBousNumber_메서드_올바르지_않은_숫자_범위() {
        assertThatThrownBy(() -> inputValidate.validateInputBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_NOT_PROPER_NUMBER_RANGE);
    }
}