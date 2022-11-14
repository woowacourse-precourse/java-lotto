package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    private static final String EXCEPTION_MESSAGE_DUPLICATED_NUMBER = "[ERROR] 중복된 복권번호가 있습니다.";
    private static final String EXCEPTION_MESSAGE_OVER_NUMBER_RANGE = "[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.";
    private static final int LOTTO_LOWER_NUMBER = 1;
    private static final int LOTTO_UPPER_NUMBER = 45;

    @DisplayName("정상적으로 클래스가 생성된다")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 45, 22", "27, 34, 31, 15, 42, 18, 1", "1, 2, 3, 4, 5, 6, 45"})
    void createWinningNumber(int number1, int number2, int number3,
                             int number4, int number5, int number6, int winningBonusNumber) {
        Lotto winningLottoNumber = new Lotto(List.of(number1, number2, number3, number4, number5, number6));
        boolean result = true;
        try {
            new WinningNumber(winningLottoNumber, winningBonusNumber);
        } catch (IllegalArgumentException e) {
            result = false;
        }
        assertThat(true).isEqualTo(result);
    }

    @DisplayName("당첨보너스번호가 당첨로또번호랑 중복이면 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6, 1", "1, 2, 3, 4, 5, 6, 3", "1, 2, 3, 4, 5, 6, 6"})
    void WinningBonusNumberDuplicatedNumber(int number1, int number2, int number3,
                                            int number4, int number5, int number6, int winningBonusNumber) {
        Lotto winningLottoNumber = new Lotto(List.of(number1, number2, number3, number4, number5, number6));
        assertThatThrownBy(() -> new WinningNumber(winningLottoNumber, winningBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEPTION_MESSAGE_DUPLICATED_NUMBER);
    }

    @DisplayName("당첨보너스번호가 로또번호의 범위를 벗어나면 에러가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6, 46", "1, 2, 3, 4, 5, 6, 0", "1, 2, 3, 4, 5, 6, 9999"})
    void WinningBonusNumberOverRangeNumber(int number1, int number2, int number3,
                                           int number4, int number5, int number6, int winningBonusNumber) {
        Lotto winningLottoNumber = new Lotto(List.of(number1, number2, number3, number4, number5, number6));
        assertThatThrownBy(() -> new WinningNumber(winningLottoNumber, winningBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(EXCEPTION_MESSAGE_OVER_NUMBER_RANGE,
                        LOTTO_LOWER_NUMBER, LOTTO_UPPER_NUMBER));
    }
}
