package lotto;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {
    @DisplayName("로또 당첨 번호와 보너스 번호가 중복될 시 예외가 발생한다.")
    @Test
    void createLottoAmountByDuplicateBonusNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1,2,3,4,5,6), 2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
