package lotto;

import lotto.domain.LottoWinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.utils.ErrorMessages.WINNING_NUMBERS_SEPARATOR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningNumbersTest {
    @DisplayName("로또 당첨 번호가 쉼표로 구분되어 있지 않으면 예외가 발생한다.")
    @Test
    void createWinningNumbersBySeparator() {
        assertThatThrownBy(() -> new LottoWinningNumbers("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBERS_SEPARATOR);
    }
}
