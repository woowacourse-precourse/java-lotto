package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExceptionTest {
    @DisplayName("로또 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoAmountByOnlyNumber() {
        String amount = "190k";
        assertThatThrownBy(() -> InputException.validatesLottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createLottoAmountByDivisible() {
        String amount = "1900";
        assertThatThrownBy(() -> InputException.validatesLottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void createLottoAmountByMoreThan() {
        String amount = "900";
        assertThatThrownBy(() -> InputException.validatesLottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호를 입력할 때 띄우면 예외가 발생한다.")
    @Test
    void createWinLottoNumbersBySpace() {
        String winLottoNumbers = "1, 2, 3, 4, 5, 6";
        assertThatThrownBy(() -> InputException.validatesWinLottoNumber(winLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호가 6자리가 아니라면 예외가 발생한다.")
    @Test
    void createWinLottoNumbersByLength() {
        String winLottoNumbers = "1,2,3,4";
        assertThatThrownBy(() -> InputException.validatesWinLottoNumber(winLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호가 6자리가 아니라면 예외가 발생한다.")
    @Test
    void createWinLottoNumbersByOnlyNumber() {
        String winLottoNumbers = "1,2,3,4,5,j";
        assertThatThrownBy(() -> InputException.validatesWinLottoNumber(winLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호를 입력할 때 콤마로 구분하지 않으면 예외가 발생한다.")
    @Test
    void createWinLottoNumbersBySplitComma() {
        String winLottoNumbers = "1,2,3,4,56";
        assertThatThrownBy(() -> InputException.validatesWinLottoNumber(winLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호들이 중복되면 예외가 발생한다.")
    @Test
    void createWinLottoNumbersByDuplicate() {
        String winLottoNumbers = "1,2,3,4,5,5";
        assertThatThrownBy(() -> InputException.validatesWinLottoNumber(winLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호들이 45 초과라면 예외가 발생한다.")
    @Test
    void createWinLottoNumbersByBelow() {
        String winLottoNumbers = "1,2,3,46,7,8";
        assertThatThrownBy(() -> InputException.validatesWinLottoNumber(winLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 시 숫자가 앙니라면 예외가 발생한다.")
    @Test
    void createBonusNumberByOnlyNumber() {
        String bonus = "u";
        assertThatThrownBy(() -> InputException.validatesBonusNumber(bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력할 때 1자리 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createBonusNumberBy1Length() {
        String bonus = "12";
        assertThatThrownBy(() -> InputException.validatesBonusNumber(bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력할 때 45 초과라면 예외가 발생한다.")
    @Test
    void createBonusNumberByBelow45() {
        String bonus = "46";
        assertThatThrownBy(() -> InputException.validatesBonusNumber(bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
