package lotto;

import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {

    @DisplayName("당첨번호의 수가 6자리가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6,7",9))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumber("1,1,2,3,4,5", 9))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 음수가 있으면 예외가 발생한다.")
    @Test
    void createLottoNegativeNumber() {
        assertThatThrownBy(() -> new WinningNumber("-1, 2, -3, -4, 5, -5", 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 ,가 없으면 예외가 발생한다.")
    @Test
    void noCommaSize() {
        assertThatThrownBy(() -> new WinningNumber("123456",9))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
