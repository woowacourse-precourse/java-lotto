package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;

class WinningNumbersTest {

    private Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("보너스 번호가 1~45범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "90"})
    void 보너스_번호_범위밖_생성(int bonusNumber) {
        assertThatThrownBy(() -> new WinningNumbers(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}