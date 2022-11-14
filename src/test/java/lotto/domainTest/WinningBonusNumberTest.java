package lotto.domainTest;

import lotto.domain.Lotto;
import lotto.domain.WinningBonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningBonusNumberTest {

    @Test
    @DisplayName("당첨 번호의 값이 중복되면 예외가 발생한다.")
    void createDuplicatedWinningNumbers() {
        assertThatThrownBy(() -> new WinningBonusNumber(List.of(1, 2, 3, 4, 5, 5), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createTooManyWinningNumbers() {
        assertThatThrownBy(() -> new WinningBonusNumber(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호의 값이 로또 범위를 넘어가면 예외가 발생한다.")
    void createOutOfRangeWinningNumbers() {
        assertThatThrownBy(() -> new WinningBonusNumber(List.of(1, 2, 3, 4, 5, 46), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호의 값이 로또 범위를 넘어가면 예외가 발생한다.")
    void createOutOfRangeBonusNumber() {
        assertThatThrownBy(() -> new WinningBonusNumber(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호와 당첨 번호의 값이 중복되면 예외가 발생한다.")
    void createDuplicatedBonusWinningNumbers() {
        assertThatThrownBy(() -> new WinningBonusNumber(List.of(1, 2, 3, 4, 5, 6), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
