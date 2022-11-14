package lotto.UI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputWinningAndBonusNumbersTest {
    @Test
    @DisplayName("입력된 문자열이 Lotto를 반환한다.")
    void inputWinningNumbersByString() {
        InputStream in = new ByteArrayInputStream("1,2,3,4,5,6".getBytes());
        System.setIn(in);
        Lotto lotto = new InputWinningAndBonusNumbers().inputWinningNumbers();
        assertThat(lotto.get()).contains(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest(name = "당첨 번호가 {0} 일 때")
    @ValueSource(strings = {"1. 2. 3. 4. 5. 6", "일, 이, 삼, 사, 오, 육"})
    @DisplayName("숫자, 쉼표가 아닌 것이 포함되면 예외가 발생한다.")
    void inputWinningNumbersByNotNumberOrNotComma(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> new InputWinningAndBonusNumbers().inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "보너스 번호가 {0} 일 때")
    @ValueSource(strings = {"a", "!", "한글", " "})
    @DisplayName("숫자, 쉼표가 아닌 것이 포함되면 예외가 발생한다.")
    void inputBonusNumberByNonNumeric(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> new InputWinningAndBonusNumbers().inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "당첨 번호가 {0} 보너스 번호가 {1} 일 때")
    @CsvSource({"'1,2,3,4,5,6', '6'", "'1,2,3,4,5,6', '46'"})
    @DisplayName("보너스 번호가 범위를 벗어나거나 당첨 번호와 중복되면 예외가 발생한다.")
    void inputBonusNumberByDuplicateWithWinningNumbers(String winningNumbers, String bonusNumber) {
        InputWinningAndBonusNumbers inputAnswer = new InputWinningAndBonusNumbers();
        InputStream in = new ByteArrayInputStream(winningNumbers.getBytes());
        System.setIn(in);
        inputAnswer.inputWinningNumbers();
        in = new ByteArrayInputStream(bonusNumber.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputAnswer.inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}