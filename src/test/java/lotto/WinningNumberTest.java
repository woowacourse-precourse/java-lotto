package lotto;

import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {

    @DisplayName("정상적으로 클래스가 생성된다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,45/ 22", "27,34,31,15,42,18/ 1", "1,2,3,4,5,6/ 45"}, delimiter = '/')
    void createWinningNumber(String WinningLottoNumber, String WinningbonusNumber) {
        boolean result = true;
        try {
            new WinningNumber(WinningLottoNumber, WinningbonusNumber);
        } catch (IllegalArgumentException e) {
            result = false;
        }
        assertThat(true).isEqualTo(result);
    }

    @DisplayName("당첨로또번호 입력값형식이 잘못된 경우 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {",1,2,3,4,5,6/ 45", "1,2,,3,4,5,6/ 45", "a1,2,3,4,5,6/ 45"}, delimiter = '/')
    void WinningLottoNumberWithInvalidFormat(String WinningLottoNumber, String WinningbonusNumber) {
        assertThatThrownBy(() -> new WinningNumber(WinningLottoNumber, WinningbonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 잘못된 형식의 입력입니다.");
    }

    @DisplayName("당첨보너스번호가 숫자가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6/ a", "1,2,3,4,5,6/ $%", "1,2,3,4,5,6/ \n"}, delimiter = '/')
    void WinningBonusNumberWithNotNumber(String WinningLottoNumber, String WinningbonusNumber) {
        assertThatThrownBy(() -> new WinningNumber(WinningLottoNumber, WinningbonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 아닌 입력 또는 입력범위를 초과 했습니다.");
    }

    @DisplayName("당첨보너스번호가 당첨로또번호랑 중복이면 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6/ 1", "1,2,3,4,5,6/ 3", "1,2,3,4,5,6/ 6"}, delimiter = '/')
    void WinningBonusNumberWithDuplicatedNumber(String WinningLottoNumber, String WinningbonusNumber) {
        assertThatThrownBy(() -> new WinningNumber(WinningLottoNumber, WinningbonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 복권번호가 있습니다.");
    }

    @DisplayName("당첨보너스번호가 로또번호의 범위를 벗어나면 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6/ 46", "1,2,3,4,5,6/ 0", "1,2,3,4,5,6/ 9999"}, delimiter = '/')
    void WinningBonusNumberWithOverRangeNumber(String WinningLottoNumber, String WinningbonusNumber) {
        assertThatThrownBy(() -> new WinningNumber(WinningLottoNumber, WinningbonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
