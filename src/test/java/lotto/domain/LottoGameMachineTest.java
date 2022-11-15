package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.exception.AmountPaymentException;
import lotto.domain.exception.BonusInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGameMachineTest {

    private AmountPaymentException amountPaymentException;

    @BeforeEach
    void setUp() {
        amountPaymentException = new AmountPaymentException();
    }

    @Test
    void 구입금액이_문자인_경우_예외() {
        assertThatThrownBy(() -> amountPaymentException.validateCharacters("asdf"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 문자를 입력 하였습니다.");
    }

    @Test
    void 사용자가_천원단위로_금액을_내지_않았다면_예외() {
        assertThatThrownBy(() -> amountPaymentException.validateSizeLottos(1234))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액이 천원 단위가 아니거나 천원 미만을 입력 하였습니다.");
    }

    @Test
    void 금액이_0원이라면_예외_발생() {
        assertThatThrownBy(() -> amountPaymentException.validateZero(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("지불하실 금액은 0보다 커야 합니다.");
    }

    @Test
    void 보너스_번호가_1부터_45사이의_숫자가_아니라면_예외_발생() {
        BonusInputException bonusInputException = new BonusInputException();
        assertThatThrownBy(() -> bonusInputException.validateBetween(47))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 보너스가_번호가_6자리_당첨_번호랑_중복일_경우_예외() {
        BonusInputException bonusInputException = new BonusInputException();
        assertThatThrownBy(() -> bonusInputException.validateDuplicate(List.of(1,2,3,4,5,6), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨번호와 중복되는 값을 입력하였습니다.");
    }
}