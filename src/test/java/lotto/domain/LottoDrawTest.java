package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoDrawTest {

    @ParameterizedTest(name = "당첨 번호가 {0}이고 보너스 번호가 45일 때")
    @ValueSource(strings = {"1,2,3,4,5", "1, 2, 3, 4, 5, 46", "error,1,2,3,4,5", "1.2.3.4.5.6", "1,2,3,4,5,6,7"})
    @DisplayName("당첨 번호가 1~45사이의 숫자가 아니면 예외가 발생한다.")
    void drawWinningNumbers_InvalidNumber_ExceptionThrown(String winningNumbers) {
        String bonusNumber = "45";
        assertThatThrownBy(() -> new DrawLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "당첨 번호가 1~6이고 보너스 번호가 {0}일 때 ")
    @ValueSource(strings = {"0", "46", "a", "1"})
    @NullAndEmptySource
    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니거나 당첨 번호와 중복되면 예외가 발생한다.")
    void validateBonusNumber_InvalidNumber_ExceptionThrown(String bonusNumber) {
        String winningNumbers = "1,2,3,4,5,6";
        assertThatThrownBy(() -> new DrawLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}