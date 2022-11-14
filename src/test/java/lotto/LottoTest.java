package lotto;

import lotto.domain.Lotto;
import lotto.exception.InputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    // 아래에 추가 테스트 작성 가능

    /*
    로또 금액 입력 예외
     */

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

    /*
    당첨 로또 번호 입력 예외
     */

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
    void createLottoAmountBySplitComma() {
        String amount = "123456";
        assertThatThrownBy(() -> InputException.validatesLottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호들이 중복되면 예외가 발생한다.")
    @Test
    void createLottoAmountByDuplicate() {
        String amount = "1,2,3,4,5,5";
        assertThatThrownBy(() -> InputException.validatesLottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호들이 45 초과라면 예외가 발생한다.")
    @Test
    void createLottoAmountByBelow() {
        String amount = "1,2,3,46,7,8";
        assertThatThrownBy(() -> InputException.validatesLottoAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /*
    보너스 번호 입력 예외
     */

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
