package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    Validation validation = new Validation();

    @Test
    @DisplayName("로또 구입 금액이 숫자 형태가 아니면 예외가 발생한다.")
    void invalidFormatPurchaseTest() {
        assertThatThrownBy(() -> validation.checkPurchaseInput(" ㅁㄴㅇㄹ "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_FORMAT.getErrorMsg());
    }

    @Test
    @DisplayName("로또 구입 금액이 1000으로 나눠지지 않으면 예외가 발생한다")
    void invalidCostPurchaseTest() {
        assertThatThrownBy(() -> validation.checkPurchaseInput(" ㅁㄴㅇㄹ "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_FORMAT.getErrorMsg());
    }

    @Test
    @DisplayName("로또 구입 번호의 갯수가 6개가 아니면 예외가 발생한다.")
    void invalidAmountWinningNumberTest() {
        assertThatThrownBy(() -> validation.checkWinningNumberInput("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_LENGTH.getErrorMsg());
    }

    @Test
    @DisplayName("로또 구입 번호 중 중복이 있으면 예외가 발생한다.")
    void duplicateWinningNumberTest() {
        assertThatThrownBy(() -> validation.checkWinningNumberInput("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.DUPLICATED_NUMBER.getErrorMsg());
    }

    @Test
    @DisplayName("로또 구입 번호가 숫자 형태가 아니면 예외가 발생한다.")
    void invalidFormatWinningNumberTest() {
        assertThatThrownBy(() -> validation.checkWinningNumberInput("ㅁ,ㄴ,ㅇ,ㄹ,ㄱ,ㅂ"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_FORMAT.getErrorMsg());
    }

    @Test
    @DisplayName("로또 구입 번호의 범위가 1 ~ 45가 아니면 예외가 발생한다.")
    void invalidRangeWinningNumberTest() {
        assertThatThrownBy(() -> validation.checkWinningNumberInput("0,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_RANGE.getErrorMsg());
    }

    @Test
    @DisplayName("로또 보너스 번호가 숫자 형태가 아니면 예외가 발생한다.")
    void invalidFormatBonusNumberTest() {
        assertThatThrownBy(() -> validation.checkBonusNumberInput("12j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_FORMAT.getErrorMsg());
    }

    @Test
    @DisplayName("로또 보너스 번호의 범위가 1 ~ 45가 아니면 예외가 발생한다.")
    void invalidRangeBonusNumberTest() {
        assertThatThrownBy(() -> validation.checkBonusNumberInput("47"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_RANGE.getErrorMsg());
    }

    @Test
    @DisplayName("로또 번호의 갯수가 6개가 아니면 예외가 발생한다.")
    void invalidAmountLottoNumberTest() {
        assertThatThrownBy(() -> validation.checkLottoNumbers(new ArrayList<>(List.of(1, 2, 3, 4, 5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_LENGTH.getErrorMsg());
    }

    @Test
    @DisplayName("로또 번호 중 중복이 있으면 예외가 발생한다.")
    void duplicateLottoNumberTest() {
        assertThatThrownBy(() -> validation.checkLottoNumbers(new ArrayList<>(List.of(1, 2, 3, 4, 5, 5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.DUPLICATED_NUMBER.getErrorMsg());
    }

    @Test
    @DisplayName("로또 번호의 범위가 1 ~ 45가 아니면 예외가 발생한다.")
    void invalidRangeLottoNumberTest() {
        assertThatThrownBy(() -> validation.checkLottoNumbers(new ArrayList<>(List.of(1, 2, 3, 4, 5, 46))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorType.INVALID_RANGE.getErrorMsg());
    }
}